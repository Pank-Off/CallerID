package com.technopark.callerid.model

import android.content.Context
import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import kotlin.concurrent.thread

class FirebaseWorker(private val context: Context?) {
    lateinit var firebaseStorage: FirebaseStorage
    private lateinit var storageReference: StorageReference
    private val nameDB = "CloudPhoneDB.db"
    private var result = false

    fun download(): Boolean {
        val path = context?.getDatabasePath(nameDB)?.parent
        val rootPath = File(path)

        storageReference = FirebaseStorage.getInstance().reference.child("phoneTable.db")
        if (!rootPath.exists()) {
            rootPath.mkdirs()
        }
        val localFile = File(rootPath, nameDB)
        Log.d("Path", localFile.toString())

        storageReference.getFile(localFile).addOnSuccessListener {
            Log.e("firebase ", ";local tem file created  created $localFile")
            result = true
        }.addOnFailureListener { exception ->
            Log.e("firebase ", ";local tem file not created  created $exception")
            result = false
        }

        Thread.sleep(3000) //Пока так, сорян

        return result
    }
}