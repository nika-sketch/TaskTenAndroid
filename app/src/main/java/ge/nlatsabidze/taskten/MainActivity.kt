package ge.nlatsabidze.taskten

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import android.view.LayoutInflater
import androidx.viewpager2.widget.ViewPager2
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import ge.nlatsabidze.taskten.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val text = arrayOf("First", "Second", "Third")
        val textForImage = arrayOf("this is first", "This is Second", "this is third")
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = ViewAdapter(text, textForImage)

    }

    class ViewAdapter(private val images: Array<String>, private val textForImages: Array<String>): RecyclerView.Adapter<ViewAdapter.imageViewHolder>() {

        var sizeOfImages = 0
        var currentPosition = 0

        inner class imageViewHolder(view: View):RecyclerView.ViewHolder(view) {
            val text: TextView = view.findViewById<TextView>(R.id.textView)
            val image: ImageView = view.findViewById<ImageView>(R.id.imageView3)
            val textForImage: TextView = view.findViewById<TextView>(R.id.textView2)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): imageViewHolder {
            return imageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_model, parent, false))
        }

        override fun onBindViewHolder(holder: imageViewHolder, position: Int) {
            holder.text.text = images[position]
            holder.image.setImageResource(R.drawable.ic_launcher_foreground)
            holder.textForImage.text = textForImages[position]

            currentPosition = position
        }

        override fun getItemCount(): Int {
            sizeOfImages = images.size

            return sizeOfImages
        }

    }

}