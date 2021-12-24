 package com.jether.wirentii;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jether.wirentii.RetrofitApi.ApiClient;
import com.jether.wirentii.RetrofitApi.ApiInterface;
import com.jether.wirentii.RetrofitApi.Users;
import com.jether.wirentii.Sessions.SharedPrefManager;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPropertyActivity extends AppCompatActivity {

    private String ID, UserID, PropertyTitle, Address, CountryName, City, Status, RentorsalePrice, PropertyID, FeaturedImage, GalleryImage1, GalleryImage2, GalleryImage3, StateName,
            GalleryImage4, GalleryImage5, Area, Bedrooms, Bathrooms, Size, Floors, Garages, PropertDescription, Location;

    private static final int IMAGE = 100;
    SharedPrefManager sharedPrefManager;
    FloatingActionButton fab1;
    TextView user,papa;
    EditText title, desc, loca, floors, bedrooms, bathrooms, garages, area, size, rentPrice, before, after, address, statuseee;

    private static final int REQUEST_CAMERA = 101;
    private static final int PICK_IMAGE_REQUEST = 102;
    private static final int REQUEST_CODE_CROP_IMAGE = 103;
    private Bitmap cameraBitmap;
    private ImageView imgPro, imgUploadPro;
    public static final String UPLOAD_KEY = "image";
    public static ApiInterface apiInterface;
    Button add;
    Spinner city, status;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_property);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sharedPrefManager = new SharedPrefManager(this);
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);


        ID = getIntent().getStringExtra("ID");
        UserID = getIntent().getStringExtra("UserID");
        PropertyTitle = getIntent().getStringExtra("PropertyTitle");
        Address = getIntent().getStringExtra("Address");
        CountryName = getIntent().getStringExtra("CountryName");
        StateName = getIntent().getStringExtra("StateName");
        City = getIntent().getStringExtra("City");
        Status = getIntent().getStringExtra("Status");
        RentorsalePrice = getIntent().getStringExtra("RentorsalePrice");
        PropertyID = getIntent().getStringExtra("PropertyID");
        FeaturedImage = getIntent().getStringExtra("FeaturedImage");
               Area = getIntent().getStringExtra("Area");
        Bedrooms = getIntent().getStringExtra("Bedrooms");
        Bathrooms = getIntent().getStringExtra("Bathrooms");
        Size = getIntent().getStringExtra("Size");
        Floors = getIntent().getStringExtra("Floors");
        Garages = getIntent().getStringExtra("Garages");
        PropertDescription = getIntent().getStringExtra("PropertDescription");
        Location = getIntent().getStringExtra("Location");

        back=findViewById(R.id.back);

        imgUploadPro=findViewById(R.id.imgUploadProfile);
        imgPro=findViewById(R.id.imageView);
        papa=findViewById(R.id.pro_id);

        status = findViewById(R.id.status);
        city = findViewById(R.id.city256);

        fab1 = findViewById(R.id.fabChoosePic1);


        add = findViewById(R.id.request1);

        user = findViewById(R.id.userId);

        HashMap<String, String> kojo = sharedPrefManager.getUserDetail();
        String muntu = kojo.get(SharedPrefManager.ID);
        user.setText(muntu);

        //text
        title = findViewById(R.id.name22);
        desc = findViewById(R.id.email);
        loca = findViewById(R.id.location);
        floors = findViewById(R.id.floors);
        bedrooms = findViewById(R.id.bedrooms);
        bathrooms = findViewById(R.id.bath);
        garages = findViewById(R.id.garages);
        area = findViewById(R.id.area);
        size = findViewById(R.id.size);
        rentPrice = findViewById(R.id.rent);
//        before=findViewById(R.id.before);
//        after=findViewById(R.id.after);
        address = findViewById(R.id.address333);


        add = findViewById(R.id.request1);

        papa.setText(ID);
        title.setText(PropertyTitle);
        desc.setText(PropertDescription);
        loca.setText(Location);
        bedrooms.setText(Bedrooms);
        bathrooms.setText(Bathrooms);
        floors.setText(Floors);
        garages.setText(Garages);
        area.setText(Area);
        size.setText(Size);
        rentPrice.setText(RentorsalePrice);

        address.setText(Address);


        try {
            Picasso.get().load(FeaturedImage).placeholder(R.drawable.ic_b_house_24).into(imgPro);

        } catch (Exception e) {

        }


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String i=papa.getText().toString().trim();
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


                BitmapDrawable drawable = (BitmapDrawable) imgPro.getDrawable();
                Bitmap profileBitmap = drawable.getBitmap();

                Bitmap bitmap = null;

                if (cameraBitmap == null) {
                    bitmap = profileBitmap;
                } else {
                    bitmap = cameraBitmap;
                }

                final String image = getStringImage(bitmap);





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

                else {
                    ProgressDialog dialog = new ProgressDialog(EditPropertyActivity.this);
                    dialog.setTitle("Editing Property...");
                    dialog.setMessage("Please wait while we edit you property...");
                    dialog.show();
                    dialog.setCanceledOnTouchOutside(false);

                    Call<Users> update = apiInterface.upPro(i,user_i,pro_ti,pro_desc,pro_status,pro_loc,pro_floo,pro_bedro,pro_bathss,pro_gara,pro_areaa,pro_sizes,pro_lenti,image,pro_add,pro_city);
                    update.enqueue(new Callback<Users>() {
                        @Override
                        public void onResponse(Call<Users> call, Response<Users> response) {

                            if (response.body().getResponse().equals("Ok")) {

                                Toast.makeText(EditPropertyActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();

                            } else if (response.body().getResponse().equals("failed")) {

                                Toast.makeText(EditPropertyActivity.this, "Failed", Toast.LENGTH_SHORT).show();
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


        imgUploadPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseFile();
            }



        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(EditPropertyActivity.this,MyPropertiesActivity.class);
                startActivity(intent);
            }
        });


        populateStatus();

        populateCity();

    }


    private void populateCity() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
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
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Rental");
        adapter.add("Hostel");
        adapter.add("Tousrist BnB");
        status.setAdapter(adapter);
        status.setSelection(0);
    }



    private void chooseFile() {
        final CharSequence[] items = { "Choose from Gallery",
                "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(EditPropertyActivity.this);
        builder.setTitle("Edit Property!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

//                if (items[item].equals("Take Photo")) {
//
//                    cameraIntent();
//
//                }


                 if (items[item].equals("Choose from Gallery")) {

                    galleryIntent();

                }


                else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File out = Environment.getExternalStorageDirectory();
        out = new File(out, "abc");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(out));
        startActivityForResult(intent, REQUEST_CAMERA);
    }


    private void galleryIntent() {

        Intent i = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, PICK_IMAGE_REQUEST);
    }





    private void performCrop(Uri picUri) {
        try {

            Intent cropIntent = new Intent("com.android.camera.action.CROP");
            // indicate image type and Uri
            cropIntent.setDataAndType(picUri, "image/*");
            // set crop properties
            cropIntent.putExtra("crop", "true");
            // indicate aspect of desired crop
            cropIntent.putExtra("aspectX", 1);
            cropIntent.putExtra("aspectY", 1);
            // indicate output X and Y
            cropIntent.putExtra("outputX", 256);
            cropIntent.putExtra("outputY", 256);
            // retrieve data on return
            cropIntent.putExtra("return-data", true);
            // start the activity - we handle returning in onActivityResult
            startActivityForResult(cropIntent, REQUEST_CODE_CROP_IMAGE);
        } catch (ActivityNotFoundException anfe) {
            String errorMessage = "your device doesn't support the crop action!";
            Toast toast = Toast
                    .makeText(this, errorMessage, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            switch (requestCode) {

                case PICK_IMAGE_REQUEST:

                    Uri u = data.getData();
                    performCrop(u);

                    break;

                case REQUEST_CAMERA:

                    File file = new File(Environment.getExternalStorageDirectory()
                            + File.separator + "abc");
                    // Crop the captured image using an other intent
                    try {
                        /* the user's device may not support cropping */
                        performCrop(Uri.fromFile(file));
                    } catch (ActivityNotFoundException aNFE) {
                        // display an error message if user device doesn't support
                        String errorMessage = "Sorry - your device doesn't support the crop action!";
                        Toast toast = Toast.makeText(this, errorMessage,
                                Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    break;

                case REQUEST_CODE_CROP_IMAGE:

                    if (resultCode == Activity.RESULT_OK) {
                        Bundle extras = data.getExtras();
                        cameraBitmap = extras.getParcelable("data");
                        imgPro.setImageBitmap(cameraBitmap);
                    }
                    break;
            }
        }
    }




    @Override
    public void onStart() {
        super.onStart();

        if (!sharedPrefManager.isLogin()) {

            sharedPrefManager.editor.clear();
            sharedPrefManager.editor.commit();

            Intent intent = new Intent(EditPropertyActivity.this,BottomActivity.class);
            startActivity(intent);
        }else{

        }
    }
}