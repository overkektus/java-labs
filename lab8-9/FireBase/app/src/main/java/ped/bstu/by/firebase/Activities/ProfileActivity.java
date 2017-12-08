package ped.bstu.by.firebase.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

import es.dmoral.toasty.Toasty;
import ped.bstu.by.firebase.R;
import ped.bstu.by.firebase.Student;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private final String ADMINID = "cTjCFAkZIcgGn3glMFPriDCPQRi1";

    private TextView tvVerified;
    private ImageView studentImage;
    private EditText etDisplayName;
    private ProgressBar progressBar;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private Student student;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        initViews();
        loadUserInformation();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

        if(mAuth.getCurrentUser().getUid().equals(ADMINID)) {
            finish();
            startActivity(new Intent(this, AdminActivity.class));
        }
    }

    private void initViews() {
        tvVerified = findViewById(R.id.tvVerified);
        etDisplayName = findViewById(R.id.etDisplayName);
        studentImage = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);
    }

    private void loadUserInformation() {
        final FirebaseUser user = mAuth.getCurrentUser();

        if(user != null) {
            if(user.getPhotoUrl() != null) {
                String photoUrl = user.getPhotoUrl().toString();

                Glide.with(this)
                        .load(user.getPhotoUrl().toString())
                        .into(studentImage);
            }
            if(user.getDisplayName() != null) {
                String displayName = user.getDisplayName();
                etDisplayName.setText(displayName);
            }

            if(user.isEmailVerified()) {
                tvVerified.setText("Email Verified");
            } else {

                tvVerified.setText("Email NOT Verified (Click to verified)");
                tvVerified.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toasty.info(ProfileActivity.this, "Verification email sent", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        }
        //student = new Student(user.getPhotoUrl().toString(), null, null, null, user.getDisplayName(), null, null ,null);
    }

    private void showToastMessage(Context context, String text, String type) {
        switch (type) {
            case "success":
                Toasty.success(context, text, Toast.LENGTH_SHORT).show();
                break;
            case "warning":
                Toasty.warning(context, text, Toast.LENGTH_SHORT).show();
                break;
            case "info":
                Toasty.info(context, text, Toast.LENGTH_SHORT).show();
                break;
            case "error":
                Toasty.error(context, text, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu_editInformation:
                intent = new Intent(this, EditProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.signout:
                showExitDialog();
                break;
            case R.id.about:
                showAboutDialog();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showExitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
        builder.setTitle("Exit")
                .setMessage("Вы действительно хотите выйти?")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mAuth.signOut();
                        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showAboutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
        builder.setTitle("About")
                .setMessage("Лабораторная работа 8-9 \n" +
                        "Выполнил: Пискунов Е.Д 7-2")
                .setIcon(R.drawable.ic_info_outline_white_48dp)
                .setCancelable(false)
                .setNegativeButton("close",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
