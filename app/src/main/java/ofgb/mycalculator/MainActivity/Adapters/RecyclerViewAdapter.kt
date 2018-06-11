package ofgb.mycalculator.MainActivity.Adapters

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ofgb.mycalculator.R
import java.io.ByteArrayOutputStream


class RecyclerViewAdapter(private val context: Context, private val galleryList: ArrayList<Bitmap>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){


    private var bitmapOptions = BitmapFactory.Options()
    private lateinit var bitmap: Bitmap

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.photo_gallery_cell, parent, false)
        bitmapOptions.inJustDecodeBounds = true

        Log.d("Test", "how many timfdfdasfdasfdasfadssfdafdsaadsffadsfadsfadsfadses tho")



        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return galleryList.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerViewAdapter.ViewHolder, position: Int) {
        viewHolder.img.scaleType = ImageView.ScaleType.CENTER_CROP
        viewHolder.img.setImageBitmap(galleryList.get(position))
        Log.d("Test", "how many times tho")
    }


    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        //private val title: TextView
         var img: ImageView

        private fun getImage():ImageView{
            return img
        }

        init {

           // title = view.findViewById(R.id.title)
            img = view.findViewById(R.id.img) as ImageView
        }
    }

    private fun getCompressedBitmap(bitmap: Bitmap): Bitmap{
        var byteOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteOutputStream)
        var byteArray = byteOutputStream.toByteArray()
        return BitmapFactory.decodeByteArray(byteArray,0,byteArray.size)

    }

}


