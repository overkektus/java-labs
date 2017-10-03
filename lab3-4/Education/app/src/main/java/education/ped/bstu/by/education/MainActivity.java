package education.ped.bstu.by.education;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import education.ped.bstu.by.education.main.Main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Main.main();
    }
}
