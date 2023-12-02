package com.example.disaster

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.disaster.database.Disaster
import com.example.disaster.database.DisasterDatabase
import com.example.disaster.database.DisasterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStream

class AddDisasters : AppCompatActivity() {
    lateinit var adapter: DisasterAdapter
    lateinit var viewModel:MainActivityData
    private var selectedPhotoPath: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_disasters)

        val recyclerView:RecyclerView = findViewById(R.id.recyclerView)
        val repository = DisasterRepository(DisasterDatabase.getInstance(this))
        val viewModel = ViewModelProvider(this)[MainActivityData::class.java]


        val back:Button=findViewById(R.id.button2)
        back.setOnClickListener{
            var intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }




        viewModel.data.observe(this){
            adapter = DisasterAdapter(it,repository,viewModel)
            recyclerView.adapter=adapter
            recyclerView.layoutManager = LinearLayoutManager(this)

        }

        CoroutineScope(Dispatchers.IO).launch {
            val data =repository.getAllDisaster()
            runOnUiThread{
                viewModel.setData(data)
            }
        }

        val addItem:Button =findViewById(R.id.button)
        addItem.setOnClickListener{
            displayAlert(repository)

        }

    }

    private fun displayAlert(repository: DisasterRepository) {
        val builder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.add_disaster_dialog, null)
        val editTextTitle = dialogView.findViewById<EditText>(R.id.editTextTitle)
        val editTextDistrict = dialogView.findViewById<EditText>(R.id.editTextDistrict)
        val editTextDis = dialogView.findViewById<EditText>(R.id.editTextDis)
        val btnUploadPhoto = dialogView.findViewById<ImageView>(R.id.selectphoto)

        builder.setView(dialogView)
            .setTitle(getText(R.string.alartTitle))
            .setPositiveButton("Save") { dialog,which->
                val title = editTextTitle.text.toString()
                val district = editTextDistrict.text.toString()
                val dis = editTextDis.text.toString()
                // Handle the photo upload here if needed
                // Call the repository method to save the data
                if (title.isNotBlank() && district.isNotBlank() && dis.isNotBlank()) {
                    val disaster = Disaster(title, district, dis, selectedPhotoPath!!) // Provide the correct photoPath
                    CoroutineScope(Dispatchers.IO).launch {
                        repository.insert(disaster)
                    }
                }
            }
            .setNegativeButton("Cancel") {
                dialog,which->
                dialog.cancel()
            }
            .show()

        btnUploadPhoto.setOnClickListener {
            val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(galleryIntent, 1)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri = data.data!!
            selectedPhotoPath = getPathFromUri(selectedImageUri)
        }
    }

    private fun getPathFromUri(uri: Uri): String {
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = contentResolver.query(uri, projection, null, null, null)
        val columnIndex = cursor!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        val path = cursor.getString(columnIndex)
        cursor.close()
        return path
    }


}