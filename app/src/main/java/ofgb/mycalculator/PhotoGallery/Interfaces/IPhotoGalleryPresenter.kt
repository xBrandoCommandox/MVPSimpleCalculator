package ofgb.mycalculator.PhotoGallery.Interfaces

import android.content.Context
import android.graphics.Bitmap

interface IPhotoGalleryPresenter{

    interface View{

        //to view
        fun setImageView(image: Bitmap)
        fun setImageList(imagePathList: ArrayList<Bitmap>)
    }

    fun loadPhotos()

    fun tempLoadPhotos(context: Context)


}