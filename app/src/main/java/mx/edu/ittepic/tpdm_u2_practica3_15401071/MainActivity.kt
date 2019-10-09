package mx.edu.ittepic.tpdm_u2_practica3_15401071

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.security.AccessControlContext
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var N : EditText?=null
    var M : EditText?=null
    var btn : Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        N=findViewById(R.id.N)
        M=findViewById(R.id.M)
        btn=findViewById(R.id.generar)

        btn?.setOnClickListener {

            Task1(N?.text.toString().toInt(),M?.text.toString().toInt()).execute()

        }


    }
    class Task1(n:Int, m:Int): AsyncTask<Void, Void, List<Int>>(){
        var N=n
        var M=m

        override fun doInBackground(vararg p0: Void?): List<Int> {
           var numeros = List(size = 2000){ Random.nextInt(N,M)}
            println(numeros)
            return numeros
        }

        override fun onPostExecute(result: List<Int>?) {
            super.onPostExecute(result)
            var cont=0
            var res=0
            (0..1999).forEach {
                cont=0
                res=result?.get(it).toString().toInt()
                (1..res).forEach{
                    if (res%it==0){
                        cont++
                    }

                }
            }
        }

    }
}
