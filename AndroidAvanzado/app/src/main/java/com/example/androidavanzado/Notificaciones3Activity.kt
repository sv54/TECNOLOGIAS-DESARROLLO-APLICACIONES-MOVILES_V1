package com.example.androidavanzado


import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.androidavanzado.R

class Notificaciones3Activity : AppCompatActivity() {
    private val CHANNEL_ID = "mi_canal_de_notificacion"
    private var tareasIniciadas = 0
    private val notificationId = 1


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificaciones3)

        createNotificationChannel()

        val btnIniciar = findViewById<Button>(R.id.iniciar)
        val btnDetener = findViewById<Button>(R.id.detener)
        val txtContador = findViewById<TextView>(R.id.contador)
        Log.i("My Tag", "Tag")

        btnIniciar.setOnClickListener {
            tareasIniciadas++
            updateNotification()
            txtContador.text = "Tareas iniciadas: " + tareasIniciadas.toString()
        }

        btnDetener.setOnClickListener {
            if (tareasIniciadas > 0) {
                tareasIniciadas--
                updateNotification()
            }

            txtContador.text = "Tareas iniciadas: " + tareasIniciadas.toString()
        }
    }

    private fun createNotificationChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val name = "Mi Canal"
            val description = "Descripción del canal"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = description

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun updateNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Tareas iniciadas")
            .setContentText("Tareas iniciadas: $tareasIniciadas")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(getNotificationIntent())
            .setAutoCancel(tareasIniciadas == 0)

        if (tareasIniciadas > 0) {
            with(NotificationManagerCompat.from(this)) {
                if (ActivityCompat.checkSelfPermission(
                        applicationContext,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return
                }
                notify(1, builder.build())
            }
        } else {
            // Cancel the notification when there are no tasks
            val notificationManager = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getSystemService(NotificationManager::class.java)
            } else {
                TODO("VERSION.SDK_INT < M")
            }
            notificationManager.cancel(notificationId)
    }

}

    private fun getNotificationIntent(): PendingIntent {
        val intent = Intent(this, Notificaciones3Activity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        return PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
    }
}
