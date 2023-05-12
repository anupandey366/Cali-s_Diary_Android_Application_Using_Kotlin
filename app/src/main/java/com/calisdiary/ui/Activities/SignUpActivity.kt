package com.calisdiary.ui.Activities

import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.calisdiary.Adapter.openDialog
import com.calisdiary.Interface.PopupItemClickListener
import com.calisdiary.R
import com.calisdiary.Validations.FormValidations
import com.calisdiary.ViewModel.SignUpViewModel
import com.calisdiary.api.response.CountryList
import com.calisdiary.databinding.ActivitySignUpBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import okhttp3.MultipartBody
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class SignUpActivity : AppCompatActivity(),PopupItemClickListener {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var dialog: Dialog
    private lateinit var recyclerView: RecyclerView
    var flag = ""
    lateinit var adapter: openDialog
    var stateCode = ""
    var cityCode = ""
    var countryCode = ""
    var document = ""

    private var passwordNotVisible = 0
    var filterData: ArrayList<CountryList> = ArrayList()
    var imageFile: File? = null
    var photoURI: Uri? = null
    private var CAMERA: Int = 2
    var imagePath = ""
    private val GALLERY = 1

    var image: Uri? = null

    var profilepic = ""
    var USER_IMAGE_UPLOADED_PROFILE = false
    private var base64: String? = null
    //private val viewModel: SignUpViewModel by viewModels()

    val FILE_BROWSER_CACHE_DIR = "FILE_BROWSER_CACHE_DIR"
    var requestMultiImagesAndVideos = ArrayList<MultipartBody.Part>()










    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val text = this.resources.getString(R.string.already_have_account)
        val secondName = "<font color=\"#6FCFB9\">${getString(R.string.Login)}</font>"



        binding.havingAccount.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        binding.uploadDocumentLL.setOnClickListener {
            selectPdf()
        }

        binding.tvTandC.setOnClickListener {
            val intent = Intent(this, TermsConditionActivity::class.java)
            intent.putExtra("flag", "terms")
            startActivity(intent)
        }
        binding.privacyPolicy.setOnClickListener {
            val intent = Intent(this, TermsConditionActivity::class.java)
            intent.putExtra("flag", "privacy")
            startActivity(intent)
        }


        binding.genderSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                val item = parent.getItemAtPosition(pos)

                if (item != "Select gender") {
                    binding.llGender.setBackgroundResource(R.drawable.white_border_background)
                    binding.TvGender.visibility = View.GONE
                    binding.TvGender.text = ""
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        binding.RegisterTandC.setOnClickListener {
            val checked = binding.RegisterTandC.isChecked

            if (checked) {
                binding.tvTerms.text = ""
                binding.tvTerms.isVisible = false
            } else {
                binding.tvTerms.isVisible = true
                binding.tvTerms.text = getString(R.string.accept_term_condition)
            }
        }
//        binding.userImageSelected.setOnClickListener {
//            if (ContextCompat.checkSelfPermission(
//                    this,
//                    Manifest.permission.CAMERA
//                ) != PackageManager.PERMISSION_GRANTED
//            ) {
//                RequestPermission.requestMultiplePermissions(this)
//            } else {
//                selectImage()
//            }
//        }

        binding.etFirstName.addTextChangedListener(textWatcher)
        binding.etLastName.addTextChangedListener(textWatcher)
        binding.etMail.addTextChangedListener(textWatcher)
        binding.etMobileNumber.addTextChangedListener(textWatcher)
        binding.etAddress.addTextChangedListener(textWatcher)
        binding.etCountry.addTextChangedListener(textWatcher)
        binding.etState.addTextChangedListener(textWatcher)
        binding.etZipCode.addTextChangedListener(textWatcher)
        binding.etCity.addTextChangedListener(textWatcher)
        binding.etPassword.addTextChangedListener(textWatcher)

    }
    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            if (s != null) {
                if (s.length == 1 && s.toString().startsWith("0")) {
                    s.clear();
                }
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            FormValidations.signUpVendor(
                binding.etFirstName, binding.tvFirstName, binding.firstNameLL,
                binding.etLastName, binding.tvLastName, binding.lastNameLL,
                binding.etMail, binding.tvEmail, binding.llEmail,
                binding.etMobileNumber, binding.tvMobileNumber, binding.llMobileNumber,
                binding.genderSpinner, binding.TvGender, binding.llGender,
                binding.etAddress, binding.tvAddress, binding.llAddress,
                binding.etCity, binding.tvCity, binding.llCity,
                binding.etState, binding.tvState, binding.StateLL,
                binding.etZipCode, binding.tvZip, binding.llZipCode,
                binding.etCountry, binding.tvCountry, binding.llCountry,
                binding.etPassword, binding.tvPassword, binding.llPassword,
                binding.RegisterTandC, binding.tvTerms,
                binding.uploadDocumentTv,
                binding.uploadDocumentLL,
                binding.tvDocument, this@SignUpActivity,
                profilepic, binding.userProfile,
            )

        }
    }


    @SuppressLint("InflateParams", "SetTextI18n")
//    fun openPopUp(flag: String) {
//
//        try {
//            val binding = LayoutInflater.from(this).inflate(R.layout.pop_lists, null)
//            dialog = DialogUtils().createDialog(this, binding.rootView, 0)!!
//            recyclerView = binding.findViewById(R.id.popup_recyclerView)
//            recyclerView.layoutManager = LinearLayoutManager(this)
//
//
//            val dialougTitle = binding.findViewById<TextView>(R.id.popupTitle)
//            val dialougbackButton = binding.findViewById<ImageView>(R.id.BackButton)
//            dialougbackButton.setOnClickListener { dialog.dismiss() }
//
//
//            val SearchEditText = binding.findViewById<EditText>(R.id.search_bar_edittext_popuplist)
//
//            when (flag) {
//                "State" -> {
//                    dialougTitle.text = "State"
//                    viewModel.getStateListApi(countryCode)
//
//                }
//                "City" -> {
//                    dialougTitle.text = flag
//                    viewModel.getCityListApi(countryCode, stateCode)
//
//                }
//                "Country" -> {
//                    dialougTitle.text = flag
//
//                    viewModel.getCountryApi()
//
//                }
//            }
//
//
//            SearchEditText.addTextChangedListener(textWatchers)
//
//
//
//            dialog.show()
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//        }
//
//
//    }



    //     Get Image From Camera and Gallery


    private fun selectImage() {
        val dialog = BottomSheetDialog(this)

        val view = layoutInflater.inflate(R.layout.choose_camera_bottom_sheet, null)

        dialog.setCancelable(true)

        val CameraButton = view.findViewById<ImageView>(R.id.choose_from_camera)
        CameraButton.setOnClickListener {


            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent.resolveActivity(this.packageManager) != null) {
                try {
                    imageFile = createImageFile()!!
                } catch (ex: IOException) {
                    ex.printStackTrace()
                }
                if (imageFile != null) {
                    photoURI = FileProvider.getUriForFile(
                        this,
                        "com.callisdairy.fileprovider",
                        imageFile!!
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, CAMERA)



                    dialog.dismiss()
                }
            }
        }

        val GalleryButton = view.findViewById<ImageView>(R.id.choose_from_gallery)
        GalleryButton.setOnClickListener {

//
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            intent.type = "image/*"
            startActivityForResult(intent, GALLERY)

            dialog.dismiss()
        }

        dialog.setContentView(view)


        dialog.show()
    }
    private fun createImageFile(): File? {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val image = File.createTempFile(
            imageFileName,
            ".jpg",
            storageDir
        )

        imagePath = image.absolutePath
        return image
    }





    private fun selectPdf() {
        val pdfIntent = Intent(Intent.ACTION_GET_CONTENT)
        pdfIntent.type = "application/pdf"
        pdfIntent.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(pdfIntent, 12)
    }

    override fun getData(data: String, flag: String, code: String) {
        when (flag) {
            "City" -> {
                binding.etCity.text = data
                cityCode = data
                dialog.dismiss()

            }
            "State" -> {
                binding.etState.text = data
                stateCode = code
                binding.etCity.text = ""
                dialog.dismiss()
            }
            "Country" -> {
                binding.etCountry.text = data
                countryCode = code
                binding.etState.text = ""
                binding.etCity.text = ""
                dialog.dismiss()
            }

        }
    }
}