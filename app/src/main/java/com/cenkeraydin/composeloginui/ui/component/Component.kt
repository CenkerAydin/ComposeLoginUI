package com.cenkeraydin.composeloginui.ui.component


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

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
fun ButtonOnboarding(navController: NavController){
   Row(
       modifier = Modifier.fillMaxWidth(),
       horizontalArrangement = Arrangement.spacedBy(16.dp) // Adjust the spacing as needed
   ) {
       Button(
           onClick = { navController.navigate("LoginScreen") },
           Modifier
               .fillMaxWidth()
               .weight(0.5f)
               .height(55.dp),
           border = BorderStroke(1.dp, Color.Black),
           colors = ButtonDefaults.buttonColors(
               containerColor = Color.Magenta,
               contentColor = Color.White,
           ),
           shape = RoundedCornerShape(10.dp),
       ) {
         Text(text = "Login",
             fontSize = 18.sp,
             )
       }
       Button(
           onClick = { navController.navigate("SignUpScreen") },
           Modifier
               .fillMaxWidth()
               .weight(0.5f)
               .height(55.dp),
           border = BorderStroke(1.dp, Color.Black),
           colors = ButtonDefaults.buttonColors(
               containerColor = Color.Magenta,
               contentColor = Color.White,
           ),
           shape = RoundedCornerShape(10.dp),
       ) {
           Text(
               text = "Sign In",
               fontSize = 18.sp
           )
       }
   }
}


@Composable
fun AuthText(text: String){
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(top = 16.dp),
        color = Color.Black
    )
}

@Composable
fun DividerLogin(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(Color.Black)
        )
        Text(
            text = "Or Login With",
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            color = Color.Black
        )
        Box(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(Color.Black)
        )
    }
}

@Composable
fun DividerSignUp(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(Color.Black)
        )
        Text(
            text = "Or Sign With",
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp),
            color = Color.Black
        )
        Box(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
                .background(Color.Black)
        )
    }

}

@Composable
fun AnnotatedTextSign(navController: NavController){
    val annotatedText = buildAnnotatedString {
        append("Already have an account? ")
        pushStringAnnotation(tag = "SIGN_IN", annotation = "SignIn")
        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)) {
            append("Sign In")
        }
        pop()
    }
    ClickableText(
        text = annotatedText,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = TextStyle(fontSize = 14.sp, color = Color.Black, textAlign = TextAlign.Center),
        onClick = { offset ->
            annotatedText.getStringAnnotations(tag = "SIGN_IN", start = offset, end = offset)
                .firstOrNull()?.let {
                    navController.navigate("LoginScreen")
                }
        }
    )

}

@Composable
fun AnnotatedTextLogin(navController: NavController){
    val annotatedText = buildAnnotatedString {
        append("Don't have an account? ")
        pushStringAnnotation(tag = "SIGN_IN", annotation = "SignIn")
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("Sign Up")
        }
        pop()
    }

    ClickableText(
        text = annotatedText,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = TextStyle(
            fontSize = 14.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        ),
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "SIGN_IN",
                start = offset,
                end = offset
            )
                .firstOrNull()?.let {
                    navController.navigate("SignUpScreen")
                }
        }
    )
}

@Composable
fun AnnotatedPasswordText(navController: NavController){
    val annotatedTextPassword = buildAnnotatedString {
        append("Forgot Your Password? ")
        pushStringAnnotation(tag = "recovery_it", annotation = "recoveryIt")
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append("Recovery it")
        }
        pop()
    }

    ClickableText(
        text = annotatedTextPassword,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = TextStyle(
            fontSize = 14.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        ),
        onClick = { offset ->
            annotatedTextPassword.getStringAnnotations(
                tag = "recovery_it",
                start = offset,
                end = offset
            )
                .firstOrNull()?.let {
                    navController.navigate("SignUpScreen")
                }
        }
    )
}




