package com.example.camera

import android.content.pm.PackageManager
import android.hardware.Camera
import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CameraFragment : Fragment(), SurfaceHolder.Callback {
    private lateinit var camera: Camera
    private lateinit var surfaceHolder: SurfaceHolder
    private lateinit var surfaceView: SurfaceView
    private lateinit var goToListButton: Button
    private lateinit var doPhotoButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (checkCameraPermission()){
            camera = Camera.open()
            surfaceView = view.findViewById(R.id.surfaceView)
            surfaceHolder = surfaceView.holder
            surfaceHolder.addCallback(this)
        }

        goToListButton = view.findViewById(R.id.goToListButton)
        goToListButton.setOnClickListener {
            findNavController().popBackStack()
        }

        doPhotoButton = view.findViewById(R.id.doPhotoButton)
        doPhotoButton.setOnClickListener {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val currentTime = dateFormat.format(Date())

            val photosDirectory = File(requireContext().externalMediaDirs.first(), "photos")
            val dateFile = File(photosDirectory, "date.txt")

            dateFile.appendText("\n$currentTime")
        }

    }


    override fun surfaceCreated(holder: SurfaceHolder) {
        try {
            camera.setPreviewDisplay(holder)
            camera.startPreview()
        }
        catch (e: java.lang.Exception){
            e.printStackTrace()
        }
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }


    override fun surfaceDestroyed(pO: SurfaceHolder) {
        camera.stopPreview()
        camera.release()
    }

    private fun checkCameraPermission(): Boolean{
        return if (
            requireActivity().checkSelfPermission(android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED
        ){
            true
        }else{
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA),1)
            false
        }
    }
}