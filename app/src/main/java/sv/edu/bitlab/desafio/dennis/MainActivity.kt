package sv.edu.bitlab.desafio.dennis

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

import android.util.Log
import android.widget.Spinner


class MainActivity : AppCompatActivity(), Formulario.OnFragmentInteractionListener,
    CollectionViewFragment.OnFragmentInteractionListener {

    private lateinit var nombreC: EditText
    private lateinit var correoC: EditText
    private lateinit var telefonoC: EditText
    private lateinit var enterasteC: Spinner
    val TAG = "MyMessage"

    override fun checarCampos(nombre: EditText, correo: EditText, telefono : EditText, enteraste : Spinner) {
        nombreC = nombre
        correoC = correo
        telefonoC =telefono
        enterasteC = enteraste

        val nomText = nombreC.text.toString()
        val correoText = correoC.text.toString()
        val telefonoText = telefonoC.text.toString()
        val enterasteText = enterasteC.selectedItem.toString()



        if (nomText.isNotEmpty() && correoText.isNotEmpty()) {
            val db = FirebaseFirestore.getInstance()

            // Create a new user with a first, middle, and last name
            val accounts = hashMapOf(
                "accountName" to nomText,
                "accountEmail" to correoText,
                "accountPhone" to telefonoText,
                "accountFoundOutBy" to enterasteText,
                "accountImage" to "hola.jpg"
            )

// Add a new document with a generated ID
            db.collection("accounts")
                .add(accounts as Map<String, Any>)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
            mostrarFragment2()
        }else Toast.makeText(applicationContext,"Datos no ingresados, por favor ingrese los datos para continuar", Toast.LENGTH_SHORT).show()

    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(sv.edu.bitlab.desafio.R.layout.activity_main)



        mostrarFragment1()
    }

    private fun mostrarFragment1(){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = Formulario()
        fragmentTransaction.replace(sv.edu.bitlab.desafio.R.id.containerFragment, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    private fun mostrarFragment2(){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = CollectionViewFragment()
        fragmentTransaction.replace(sv.edu.bitlab.desafio.R.id.containerFragment, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
