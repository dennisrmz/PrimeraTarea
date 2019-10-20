package sv.edu.bitlab.primeratarea

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), Formulario.OnFragmentInteractionListener, Respuesta.OnFragmentInteractionListener  {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val spinner: Spinner = findViewById(R.id.input_enteraste)
//        ArrayAdapter.createFromResource(this,
//            R.array.como_te_enteraste,
//            android.R.layout.simple_spinner_item).also {    adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinner.adapter = adapter
//        }

        val fragment = Formulario.newInstance()
        val builder = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentformulario, fragment, "FRAGMENT_TAG")
        builder.commitAllowingStateLoss()

        val fragmentNew = Respuesta.newInstance()
        val builderNew = supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentRespuesta, fragmentNew, "FRAGMENT_TAG")
        builderNew.commitAllowingStateLoss()


    }
}
