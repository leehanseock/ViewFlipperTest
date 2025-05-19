package kr.ac.kopo.viewflippertest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnPrev, btnNext;
    ViewFlipper flipper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnPrev=findViewById(R.id.btn_prev);
        btnNext=findViewById(R.id.btn_next);
        flipper1=findViewById(R.id.flipper1);
        btnPrev.setOnClickListener(btnListener);
        btnNext.setOnClickListener(btnListener);

    }
    View.OnClickListener btnListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btnEvent = (Button) v;//View는 버튼의 부모이므로 형변환이 필요
            if(btnEvent==btnPrev){
                flipper1.showPrevious();
            }else{
                flipper1.showNext();
            }
        }
    };
}