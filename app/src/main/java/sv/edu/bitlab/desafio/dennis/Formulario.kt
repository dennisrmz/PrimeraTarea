package sv.edu.bitlab.desafio.dennis

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import sv.edu.bitlab.desafio.R

class Formulario : Fragment(){

    // TODO: Rename and change types of parameters

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var collection_enviar: TextView
    private lateinit var constrain: ConstraintLayout
    private lateinit var button_enviar: Button
    private lateinit var nombre: EditText
    private lateinit var correo: EditText
    private lateinit var telefono: EditText
    private lateinit var enteraste: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_formulario, container, false)
        nombre=view.findViewById(R.id.input_name)
        correo=view.findViewById(R.id.input_email)
        telefono=view.findViewById(R.id.input_numero_telefonico)
        enteraste=view.findViewById(R.id.input_enteraste)
        constrain = view.findViewById(R.id.constraintFormulario)

        button_enviar = view.findViewById(R.id.button)
        button_enviar.setOnClickListener{
            listener?.checarCampos(nombre, correo, telefono, enteraste, constrain)
        }
        collection_enviar = view.findViewById(R.id.editTextCollection)
        collection_enviar.setOnClickListener{
            listener?.mostrarCollection()
        }

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context

        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun checarCampos(nombre: EditText, correo: EditText, telefono: EditText, enteraste : Spinner, constrain : ConstraintLayout)
        fun mostrarCollection()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Formulario.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            Formulario().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
