import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.applid.gym.R

@Composable
fun HomeAppBar(mainTxt : String, descriptionTxt : String) {

    Column() {
        Row(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
        ) {
            Column() {
                Text(text = mainTxt, style = MaterialTheme.typography.h1)
                Text(text = descriptionTxt)
            }

            Spacer(Modifier.weight(1f))
            Card(
                modifier = Modifier.size(48.dp),
                shape = CircleShape,
                elevation = 2.dp,
            ) {
                Image(
                    painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}