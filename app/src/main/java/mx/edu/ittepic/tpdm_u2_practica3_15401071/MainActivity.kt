package mx.edu.ittepic.tpdm_u2_practica3_15401071

import android.app.Activity
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.io.OutputStreamWriter
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

            Task1(N?.text.toString().toInt(),M?.text.toString().toInt(), applicationContext).execute()

        }


    }
    class Task1(n:Int, m:Int, context:Context): AsyncTask<Void, Void, List<Int>>(){
        var N=n
        var M=m
        var con = context

        override fun doInBackground(vararg p0: Void?): List<Int> {
           var numeros = List(size = 2000){ Random.nextInt(N,M)}
            return numeros
        }

        override fun onPostExecute(result: List<Int>?) {
            super.onPostExecute(result)
            var cont=0
            var res=""
            var primos=""
            (0..1999).forEach {
                cont=0
                res=result?.get(it).toString()
                (1..res.toInt()).forEach{
                    if (res.toInt()%it==0){
                        cont++
                    }


                }
                if(cont<=2 && res.toInt()>1){

                    primos=primos+res+" "

                }


            }
            generararchivo(primos)
            println(primos)

        }
       fun generararchivo(res:String){
           val guardarArchivo=OutputStreamWriter(con.openFileOutput("primos.txt",Activity.MODE_PRIVATE))
           //recibe de parametros el nombre del archivo y el modo
           guardarArchivo.write(res)
           guardarArchivo.flush()
           guardarArchivo.close()

        }
    }
}
