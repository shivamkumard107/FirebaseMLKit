package com.developersk.firebasemlkitdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutusActivity extends AppCompatActivity {
    private ImageView ivGithub, ivLinkedin1, ivMailto1, ivPortfolio, ivLinkedin2, ivMailto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_item);
        ivGithub = findViewById(R.id.iv_github);
        ivLinkedin1 = findViewById(R.id.iv_linkedin);
        ivLinkedin2 = findViewById(R.id.iv_linkedin2);
        ivMailto1 = findViewById(R.id.iv_gmail);
        ivMailto2 = findViewById(R.id.iv_gmail2);
        ivPortfolio = findViewById(R.id.iv_portfolio);

        ivGithub.setOnClickListener(github -> openlink(0));
        ivLinkedin1.setOnClickListener(link1 -> openlink(1));
        ivLinkedin2.setOnClickListener(link2 -> openlink(2));
        ivMailto1.setOnClickListener(mail1 -> openlink(3));
        ivMailto2.setOnClickListener(mail2 -> openlink(4));
        ivPortfolio.setOnClickListener(port -> openlink(5));
    }
    private void openlink(int id){
        Intent intent ;
        switch (id){
            case 0:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/shivamkumard107"));
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/shivam-kumar-a9aa96131/"));
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.linkedin.com/in/mohit-ranjan-759188169/"));
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","shivam.kumard107@gmail.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, " ");
                startActivity(Intent.createChooser(intent, null));
                break;
            case 4:
                intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","mohit.ranjan.910@gmail.com", null));
                intent.putExtra(Intent.EXTRA_SUBJECT, " ");
                startActivity(Intent.createChooser(intent, null));
                break;
            case 5:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://mohitr1999.github.io"));
                startActivity(intent);
                break;
        }
    }
}
