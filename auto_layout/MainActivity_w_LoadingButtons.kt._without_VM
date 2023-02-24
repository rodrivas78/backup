import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button elements by their IDs
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)

        // Set click listeners on the Button elements
        button1.setOnClickListener {
            // Launch a second activity when button1 is clicked
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            // Open an external link when button2 is clicked
            val uri = Uri.parse("https://www.example.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        button3.setOnClickListener {
            // Show the loading view
            showLoadingView()

            // Set up a coroutine to load content and update the view
            launch {
                // Simulate loading content from a remote server
                delay(5000)
                val content = "Loaded content"

                // Update the view with the loaded content
                val button3Text = findViewById<Button>(R.id.button3)
                button3Text.text = content

                // Hide the loading view
                hideLoadingView()
            }
        }

        button4.setOnClickListener {
            // Handle click on button4
        }
    }

    private fun showLoadingView() {
        findViewById<View>(R.id.loading_view).visibility = View.VISIBLE
    }

    private fun hideLoadingView() {
        findViewById<View>(R.id.loading_view).visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}
