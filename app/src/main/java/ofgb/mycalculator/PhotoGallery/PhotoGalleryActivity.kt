package ofgb.mycalculator.PhotoGallery

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.PermissionChecker
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import ofgb.mycalculator.MainActivity.Adapters.RecyclerViewAdapter
import ofgb.mycalculator.PhotoGallery.Interfaces.IPhotoGalleryPresenter
import ofgb.mycalculator.R

class PhotoGalleryActivity: AppCompatActivity(), IPhotoGalleryPresenter.View{



    private val PERMISSION_REQUEST_CODE: Int = 100
    private val photoGalleryPresenter = PhotoGalleryPresenter(this)
    private lateinit var imageView: ImageView

    private var imageList = ArrayList<Bitmap>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_gallery_layout)

        imageView = findViewById<ImageView>(R.id.img)


        hasAcceptedReadExternalStorage()

        var recyclerView = findViewById<RecyclerView>(R.id.imagegallery)
        recyclerView.setHasFixedSize(true)

        var recyclerViewManager = GridLayoutManager(applicationContext,2)
        recyclerView.layoutManager = recyclerViewManager

        var recyclerViewAdapter = RecyclerViewAdapter(applicationContext, imageList)
        recyclerView.adapter = recyclerViewAdapter


    }

    override fun setImageView(bitmapImage: Bitmap) {
        imageView.setImageBitmap(bitmapImage)
    }

    override fun setImageList(imagePathList: ArrayList<Bitmap>) {
        imageList = imagePathList
    }

    private fun hasAcceptedReadExternalStorage(){
        if(PermissionChecker.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            askPermission()
        }else{
           // photoGalleryPresenter.loadPhotos()

            photoGalleryPresenter.tempLoadPhotos(this)
        }
    }

    private fun askPermission(){
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults[0] != PackageManager.PERMISSION_GRANTED){
            this.finish()
        }
    }


}