package com.niec.gaurav.e_cellniec;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ContactUs extends AppCompatActivity implements View.OnClickListener {

    ImageView fb, insta, linkedIn;
    TextView Email, Chat;
    ImageView messagePrashantImage, messageGargImage, callPrashantImage, callGargImage;

    public static String FACEBOOK_URL = "https://www.facebook.com/ECELLNIEC";
    public static String FACEBOOK_PAGE_ID = "E-Cell NIEC";


    //method to get the right URL to use in the intent
    public String getFacebookPageURL(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            int versionCode = packageManager.getPackageInfo("com.facebook.katana", 0).versionCode;
            if (versionCode >= 3002850) { //newer versions of fb app
                return "fb://facewebmodal/f?href=" + FACEBOOK_URL;
            } else { //older versions of fb app
                return "fb://page/" + FACEBOOK_PAGE_ID;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return FACEBOOK_URL; //normal web url
        }
    }

    public void insta() {
        Uri uri = Uri.parse("http://instagram.com/_u/ecellniec");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://instagram.com/gaurav.upadhyay1")));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        fb = (ImageView) findViewById(R.id.fb);
        insta = (ImageView) findViewById(R.id.insta);
        Email = (TextView) findViewById(R.id.email_us);
        Chat = (TextView) findViewById(R.id.chat_now);
        linkedIn = (ImageView) findViewById(R.id.lin);
        messagePrashantImage = (ImageView) findViewById(R.id.mp);
        messageGargImage = (ImageView) findViewById(R.id.mg);
        callPrashantImage = (ImageView) findViewById(R.id.cp);
        callGargImage = (ImageView) findViewById(R.id.cg);

        fb.setOnClickListener(this);
        insta.setOnClickListener(this);

        linkedIn.setOnClickListener(this);
        messagePrashantImage.setOnClickListener(this);
        messageGargImage.setOnClickListener(this);
        callPrashantImage.setOnClickListener(this);
        callGargImage.setOnClickListener(this);
        Chat.setOnClickListener(this);
        Email.setOnClickListener(this);
    }

    public void linked() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://you"));
        final PackageManager packageManager = getBaseContext().getPackageManager();
        final List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (list.isEmpty()) {
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.linkedin.com/profile/view?id=you"));
        }
        startActivity(intent);
    }


    public void email() {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"gauravu555@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Doubt via Android Application");
        email.putExtra(Intent.EXTRA_TEXT, "To\n Entrepreneurship Cell\nNorthern India Engineering College");

//need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb:
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
                String facebookUrl = getFacebookPageURL(this);
                facebookIntent.setData(Uri.parse(facebookUrl));
                startActivity(facebookIntent);
                break;
            //handle multiple view click events


            case R.id.insta:
                insta();
                break;
            case R.id.lin:
                linked();
                break;


            case R.id.mp:
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:" + "7838658533"));
                sendIntent.putExtra("sms_body", "To\nMr Prashant Gupta\nEntrepreneurshipCell, NIEC\n ");
                startActivity(sendIntent);
                break;

            case R.id.cp:
                Intent dial = new Intent();
                dial.setAction("android.intent.action.DIAL");
                dial.setData(Uri.parse("tel:" + "7838658533"));
                startActivity(dial);
                break;

            case R.id.mg:
                Intent sendIntent2 = new Intent(Intent.ACTION_VIEW);
                sendIntent2.setData(Uri.parse("sms:" + "9811966262"));
                sendIntent2.putExtra("sms_body", "To\nMr Aakash Garg\nEntrepreneurshipCell, NIEC\n ");
                startActivity(sendIntent2);
                break;

            case R.id.cg:
                Intent dial2 = new Intent();
                dial2.setAction("android.intent.action.DIAL");
                dial2.setData(Uri.parse("tel:" + "9811966262"));
                startActivity(dial2);
                break;
            case R.id.email_us:
                email();
                break;
            case R.id.chat_now:
                Toast.makeText(getBaseContext(),"Feature coming soon...",Toast.LENGTH_LONG).show();
                break;

        }
    }
}
