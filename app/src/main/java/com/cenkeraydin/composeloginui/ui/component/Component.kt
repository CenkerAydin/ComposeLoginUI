package com.cenkeraydin.composeloginui.ui.component


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cenkeraydin.composeloginui.R
import com.cenkeraydin.composeloginui.ui.theme.ComposeLoginUITheme
import com.cenkeraydin.composeloginui.ui.theme.PrimaryPink

@Composable
fun CustomTextTitle(text: String) {

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            textAlign = TextAlign.End,
            modifier = Modifier.padding(10.dp),
            fontSize = 25.sp,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Magenta, Color.Red)
                )
            ),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CustomTextDescription(text: String) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(10.dp),
        fontSize = 25.sp,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(Color.Red, Color.Blue)
            )
        ),
        fontWeight = FontWeight.Normal
    )
}



@Composable
fun CustomButton(text: String, onClick: () -> Unit) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .size(width = 150.dp, height = 50.dp)
    ) {
        Text(text = text)
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String,
    isNavigationArrowVisible: Boolean,
    onClicked: () -> Unit,
    colors: ButtonColors,
    shadowColor: Color
) {
    Button(
        modifier = modifier
            .height(52.dp)
            .shadow(
                elevation = 24.dp,
                shape = RoundedCornerShape(percent = 50),
                spotColor = shadowColor
            ),
        onClick = onClicked,
        colors = colors
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            if (isNavigationArrowVisible) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_right),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ActionButtonPreview() {
    ComposeLoginUITheme {
        ActionButton(
            text = "Action text",
            isNavigationArrowVisible = true,
            onClicked = {},
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = PrimaryPink
            ),
            shadowColor = PrimaryPink
        )
    }
}

