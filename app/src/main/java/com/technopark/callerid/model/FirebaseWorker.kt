package com.technopark.callerid.model

import android.content.Context
import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File

class FirebaseWorker(private val context: Context) {
    lateinit var firebaseStorage: FirebaseStorage
    private lateinit var storageReference: StorageReference
    private val nameDB = "CloudPhoneDB.db"
    private var result = false

    fun download(): Boolean {
        val Path = context.getDatabasePath(nameDB).parent
        val rootPath: File = File(Path)

        storageReference = FirebaseStorage.getInstance().reference.child("phoneTable.db")
        if (!rootPath.exists()) {
            rootPath.mkdirs()
        }
        val localFile: File = File(rootPath, nameDB)
        Log.d("Path", localFile.toString())

        storageReference.getFile(localFile).addOnSuccessListener {
            Log.e("firebase ", ";local tem file created  created $localFile")
            result = true
        }.addOnFailureListener { exception ->
            Log.e("firebase ", ";local tem file not created  created $exception")
            result = false
        }
        return result
    }
}