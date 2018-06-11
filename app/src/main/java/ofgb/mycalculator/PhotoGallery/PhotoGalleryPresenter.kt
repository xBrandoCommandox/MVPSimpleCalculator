package ofgb.mycalculator.PhotoGallery

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import ofgb.mycalculator.PhotoGallery.Interfaces.IPhotoGalleryInteractor
import ofgb.mycalculator.PhotoGallery.Interfaces.IPhotoGalleryPresenter
import java.io.File

class PhotoGalleryPresenter(private val mView: IPhotoGalleryPresenter.View): IPhotoGalleryPresenter, IPhotoGalleryInteractor.Callback{

    private lateinit var imagePaths: ArrayList<Bitmap>
    private lateinit var fileList2: ArrayList<String>

    override fun loadPhotos() {

        val file = File("/sdcard/").listFiles()

       // val rootFile = File(Environment.getExternalStorageDirectory().absolutePath)
       // listDir(rootFile)
/**
        for(i in 0..file.size-1){

            if(containsImageFolder(getFileName(file.get(i).toString()))){
                val anotherFile = File((getFileName(file.get(i).toString()))).list()

                if(anotherFile != null){
                    for(j in 0..anotherFile.size-1){
                        Log.d("Test", "" + anotherFile.get(j))
                    }
                }


            }
        }



        for(i in 0..fileList.size-1){
           if(containsImageFolder(getFileName(fileList.get(i)))){
               Log.d("Test", "NICE = " + fileList.get(i))

               var something = File(fileList.get(i)).listFiles()


               for(j in 0..something.size-1){
                   Log.d("Test", "woop = " + something.get(j).path)
               }

           }
        }

        **/

    }
/**
    private fun listDir(file: File){
        var files = file.listFiles()
        fileList = ArrayList<String>(files.size)

        for(i in 0..files.size-1){
            fileList.add(files.get(i).path)
            //Log.d("Test", "" + i + "  " + fileList.get(i))
        }
    }

**/
    private fun getFileName(path: String): String{
        var fileName = path.substringAfterLast('/')
        return fileName
    }

    private fun containsImageFolder(folderName: String): Boolean{
        return folderName == "DCIM" || folderName == "Pictures" || folderName == "sdcard" || folderName == "Camera"
    }




    override fun tempLoadPhotos(context: Context){
        var columns = arrayOf(MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID)
        var orderBy = MediaStore.Images.Media._ID

        var cursor = context.contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null, null, orderBy)

        var count = cursor.getCount()
        imagePaths = ArrayList<Bitmap>()
        for(i in 0..count-1){
            cursor.moveToPosition(i)
            var dataColumnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA)
            var path = cursor.getString(dataColumnIndex)
            imagePaths.add(BitmapFactory.decodeFile(path))
        }

        mView.setImageList(imagePaths)

    }
}