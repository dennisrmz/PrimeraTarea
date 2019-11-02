package sv.edu.bitlab.desafio.dennis

import android.content.ContentValues.TAG
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.desafio.R
import sv.edu.bitlab.desafio.dennis.Models.Account
import com.google.firebase.firestore.FirebaseFirestore


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CollectionViewFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [CollectionViewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CollectionViewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    var nombre : String? = null
    var fragmentview : View? = null
    private var listener: OnFragmentInteractionListener? = null
    lateinit var mRecyclerView : RecyclerView
    val mAdapter : RecyclerAdapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmen

        fragmentview  = inflater.inflate(sv.edu.bitlab.desafio.R.layout.collection_view_fragment, container, false)



        getAccounts()

        return fragmentview



    }
    fun getAccounts(){

        var accountsColl:MutableList<Account> = mutableListOf()
        val db = FirebaseFirestore.getInstance()
        db.collection("accounts")
            .get()
            .addOnSuccessListener {result->
                for (document in result) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data["accountName"]}")
                    accountsColl.add(Account("${document.data["accountName"]}", "ore@gmail.com", "22325227", "otro", "https://firebasestorage.googleapis.com/v0/b/bitlab-students-9bb27.appspot.com/o/accounts-image%2F1572498735726_jorge.jpg?alt=media&token=3ff3a8f9-5ce6-403c-8813-f78a87b25440" ))
                    Log.d(TAG, "datos***************: ${accountsColl.size}")
                    Log.d(TAG, "ya pase account")
                    setUpRecyclerView(accountsColl)
                }

            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
        Log.d(TAG, "***pase aqui despues datos***************: ${accountsColl.size}")
        }

    fun setUpRecyclerView(account: MutableList<Account>){
        val activity = activity as Context
        mRecyclerView = this.fragmentview!!.findViewById(sv.edu.bitlab.desafio.R.id.collectionListView) as RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mAdapter.RecyclerAdapter(account, activity)
        mRecyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }


    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
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
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CollectionViewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            CollectionViewFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
