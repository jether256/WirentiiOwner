package com.jether.wirentii;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.jether.wirentii.RetrofitApi.ApiClient;
import com.jether.wirentii.RetrofitApi.ApiInterface;
import com.jether.wirentii.RetrofitApi.Users;
import com.jether.wirentii.Sessions.SharedPrefManager;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class AddPropertyActivity extends AppCompatActivity {
    private static final int REQUEST_WRITE_PERMISSION = 789;
    SharedPrefManager sharedPrefManager;
    TextView user;

    public static ApiInterface apiInterface;
    Button add;
    EditText title,desc,loca,floors,bedrooms,bathrooms,garages,area,size,rentPrice,before,after,address,statuseee;

    CircleImageView img1;

    FloatingActionButton fab1;

    private  static final int IMAGE = 100;

    public static final String INSERT_FLAG=Config.INSERT_FLAG;

    String mediaPath;



Spinner city,status;
int current_Item=0;
    private Bitmap bitmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sharedPrefManager= new SharedPrefManager(this);
        apiInterface= ApiClient.getApiClient().create(ApiInterface.class);
        //spinner

        img1=findViewById(R.id.picture1);

        status=findViewById(R.id.status);
        city=findViewById(R.id.city256);

        fab1=findViewById(R.id.fabChoosePic1);



        add=findViewById(R.id.request1);

        user=findViewById(R.id.userId);

        HashMap<String, String> kojo=sharedPrefManager.getUserDetail();
        String muntu=kojo.get(SharedPrefManager.ID);
        user.setText(muntu);

        //text
        title=findViewById(R.id.name22);
        desc=findViewById(R.id.email);
        loca=findViewById(R.id.location);
        floors  =findViewById(R.id.floors);
        bedrooms =findViewById(R.id.bedrooms);
        bathrooms=findViewById(R.id.bath);
        garages=findViewById(R.id.garages);
        area=findViewById(R.id.area);
        size=findViewById(R.id.size);
        rentPrice=findViewById(R.id.rent);
//        before=findViewById(R.id.before);
//        after=findViewById(R.id.after);
        address=findViewById(R.id.address333);










       add.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               String user_i=user.getText().toString().trim();
               String pro_ti=title.getText().toString().trim();
               String pro_desc=desc.getText().toString().trim();
               String pro_loc=loca.getText().toString().trim();
               String pro_floo=floors.getText().toString().trim();
               String pro_bedro=bedrooms.getText().toString().trim();
               String pro_bathss=bathrooms.getText().toString().trim();
               String pro_gara=garages.getText().toString().trim();
               String pro_areaa=area.getText().toString().trim();
               String pro_sizes=size.getText().toString().trim();
               String pro_lenti=rentPrice.getText().toString().trim();
               String pro_add=address.getText().toString().trim();

               String pro_city=city.getSelectedItem().toString();

               String pro_status=status.getSelectedItem().toString();


               //String base64String = Imageutil.convert(bitmap);


               String image=imageToString();



               if(TextUtils.isEmpty(pro_ti)){
                   title.setError("Property Title is required");
               }
               else if(TextUtils.isEmpty(pro_desc)){
                   desc.setError("Property decsription is required");
               }
               else if(TextUtils.isEmpty(pro_loc)){
                   loca.setError("Property Location is required");
               }
               else if(TextUtils.isEmpty(pro_floo)) {
                   floors.setError("Floors is required");
               }

               else if(TextUtils.isEmpty(pro_bedro)){
                   bedrooms.setError("Bedrooms is required");
               }
               else if(TextUtils.isEmpty(pro_bathss)){
                   bathrooms.setError("Property Location is required");
               }
               else if(TextUtils.isEmpty(pro_gara)) {
                   garages.setError("Garages is required");
               }

               else if(TextUtils.isEmpty(pro_areaa)){
                   area.setError("Area is required");
               }
               else if(TextUtils.isEmpty(pro_sizes)){
                   size.setError("Size is required");
               }
               else if(TextUtils.isEmpty(pro_lenti)) {
                   rentPrice.setError("Rentor Price is required");
               }

               else if(TextUtils.isEmpty(pro_add)) {
                   address.setError("Floors is required");
               }


               else{
                   ProgressDialog dialog=new ProgressDialog(AddPropertyActivity.this);
                   dialog.setTitle("Adding Property...");
                   dialog.setMessage("Please wait while we add you property...");
                   dialog.show();
                   dialog.setCanceledOnTouchOutside(false);

                   Call<Users> call= apiInterface.addProperty(user_i,pro_ti,pro_desc,pro_status,pro_loc,pro_floo,pro_bedro,pro_bathss,pro_gara,pro_areaa,pro_sizes,pro_lenti,image,pro_add,pro_city);
                   call.enqueue(new Callback<Users>() {
                       @Override
                       public void onResponse(Call<Users> call, Response<Users> response) {

                           if(response.body().getResponse().equals("Ok")){



                               Toast.makeText(AddPropertyActivity.this,"Property Added", Toast.LENGTH_SHORT).show();
                              

                               dialog.dismiss();
                           }
                           else if(response.body().getResponse().equals("failed")){
                               Toast.makeText(AddPropertyActivity.this, "Something went wrong,Please try again....", Toast.LENGTH_SHORT).show();
                               dialog.dismiss();
                           }

                       }

                       @Override
                       public void onFailure(Call<Users> call, Throwable t) {

                       }
                   });


               }

           }
       });

       fab1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               chooseFile();
           }



       });



        populateStatus();

        populateCity();


    }




    private void populateCity() {
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Gulu");
        adapter.add("Arua");
        adapter.add("Abim");
        adapter.add("Adjumani");
        adapter.add("Agago");
        adapter.add("Alebtong");
        adapter.add("amolatar");
        adapter.add("Amudat");
        adapter.add("Amuru");
        adapter.add("Apac");
        adapter.add("Dokolo");
        adapter.add("Kabong");
        adapter.add("Kitgum");
        adapter.add("Koboko");
        adapter.add("Kole");
        adapter.add("Kotido");
        adapter.add("Lamwo");
        adapter.add("Lira");
        adapter.add("Maracha");
        adapter.add("Moroto");
        adapter.add("Nakapiripirit");
        adapter.add("Moyo");
        adapter.add("Napak");
        adapter.add("Nebbi");
        adapter.add("Nwoya");
        adapter.add("Otuke");
        adapter.add("Oyam");
        adapter.add("Pader");
        adapter.add("Yumbe");
        adapter.add("Zombo");
        adapter.add("Buhwej");
        adapter.add("Buliisa");
        adapter.add("Bundibugyo");
        adapter.add("Bushenyi");
        adapter.add("Hoima");
        adapter.add("Isingiro");
        adapter.add("Ibanda");
        adapter.add("Kabale");
        adapter.add("Kabarole");
        adapter.add("Kamwenge");
        adapter.add("Kanungu");
        adapter.add("Kasese");
        adapter.add("Kibaale");
        adapter.add("Kiruhura");
        adapter.add("Kiryandongo");
        adapter.add("Kisoro");
        adapter.add("Kyegwegwa");
        adapter.add("Masindi");
        adapter.add("Mitooma");
        adapter.add("Ntoroko");
        adapter.add("Ntungamo");
        adapter.add("Rubiriz");
        adapter.add("Rukungiri");
        adapter.add("Sheema");
        adapter.add("Mbale");
        adapter.add("Soroti");
        adapter.add("Amuria");
        adapter.add("Budaka");
        adapter.add("Bugiri");
        adapter.add("Bukedea");
        adapter.add("Bukwa");
        adapter.add("Bulamburi");
        adapter.add("Busia");
        adapter.add("Butaleja");
        adapter.add("Buyende");
        adapter.add("Iganga");
        adapter.add("Jinja");
        adapter.add("Kaberamaido");
        adapter.add("Kamuli");
        adapter.add("Kapchorwa");
        adapter.add("Katakwi");
        adapter.add("Kibuku");
        adapter.add("Kumi");
        adapter.add("Kweni");
        adapter.add("Luuka");
        adapter.add("Manafwa");
        adapter.add("Mayuge");
        adapter.add("Mbale");
        adapter.add("Namayingo");
        adapter.add("Namutumba");
        adapter.add("Ngora");
        adapter.add("Pallisa");
        adapter.add("Serere");
        adapter.add("Tororo");
        adapter.add("Kampala");
        adapter.add("Masaka");
        adapter.add("Mukon");
        adapter.add("Rakai");
        adapter.add("Kalangala");
        adapter.add("Buikwe");
        adapter.add("Bukomansimbi");
        adapter.add("Butambala");
        adapter.add("Buvuma");
        adapter.add("Gomba");
        adapter.add("Kalungu");
        adapter.add("Kayunga");
        adapter.add("Kiboga");
        adapter.add("Kyankwanzi");
        adapter.add("Luweero");
        adapter.add("Lwengo");
        adapter.add("Lyantonde");
        adapter.add("Mityana");
        adapter.add("Mpigi");
        adapter.add("Mubende");
        adapter.add("Mbarara");
        adapter.add("Nakaseke");
        adapter.add("Nakasongola");
        adapter.add("Sembabule");
        adapter.add("Wakiso");


        city.setAdapter(adapter);
        city.setSelection(0);

    }


    private void populateStatus() {
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Rental");
        adapter.add("Hostel");
        adapter.add("Tousrist BnB");
        status.setAdapter(adapter);
        status.setSelection(0);
    }


    private void chooseFile() {
        Intent intent= new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(requestCode==IMAGE && resultCode==RESULT_OK && data !=null) {

            Uri path= data.getData();
            try {
                bitmap=MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                img1.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }


    private String imageToString(){
        ByteArrayOutputStream byteArrayOutputStream= new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imgByte=byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte, Base64.DEFAULT);
    }



       @Override
    public void onStart() {
        super.onStart();

        if (!sharedPrefManager.isLogin()) {

            sharedPrefManager.editor.clear();
            sharedPrefManager.editor.commit();

            Intent intent = new Intent(AddPropertyActivity.this,BottomActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }else{

        }
    }


}