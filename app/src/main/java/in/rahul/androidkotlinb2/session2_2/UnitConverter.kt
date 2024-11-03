package `in`.rahul.androidkotlinb2.session2_2

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToLong

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConverter() {
    val context = LocalContext.current
    var unitsList by remember { mutableStateOf(lengthList) }
    var expandedTo by remember { mutableStateOf(false) }
    var expandedFrom by remember { mutableStateOf(false) }
    var selectedTo by remember { mutableStateOf(unitsList[0]) }
    var selectedFrom by remember { mutableStateOf(unitsList[0]) }
    var inputValue by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column {
        Text(
            text = "Pick a Category",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        LazyRow(
            contentPadding = PaddingValues(8.dp)
        ) {
            items(categoryList){ list ->
                Card(
                    modifier = Modifier.padding(10.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFF7F2F9)
                    ),
                    onClick = {
                        when(list.first) {
                            Units.LENGTH.name -> {
                                unitsList = lengthList
                            }
                            Units.AREA.name -> {
                                unitsList = areaList
                            }
                            Units.TIME.name -> {
                                unitsList = timeList
                            }
                            Units.WEIGHT.name -> {
                                unitsList = weightList
                            }
                        }
                    }
                ) {
                    Text(text = list.first, modifier = Modifier.padding(12.dp))
                }
            }
        }
        Text(
            text = "Unit Converter",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
        // Convert From
        Row {
            Text(
                text = "Convert From :",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(all = 14.dp),
                textAlign = TextAlign.Start
            )
            Box(
                modifier = Modifier.padding(start = 16.dp, top = 6.dp)
            ) {
                Button(onClick = { expandedFrom = true }) {
                    Text(text = selectedFrom.unitName)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }

                DropdownMenu(
                    expanded = expandedFrom,
                    onDismissRequest = { expandedFrom = false },
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 16.dp)
                ) {
                    unitsList.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item.name) },
                            onClick = {
                                selectedFrom = item
                                expandedFrom = false
                                Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }
            }
        }

        // Convert to
        Row {
            Text(
                text = "Convert To :",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(all = 14.dp),
                textAlign = TextAlign.Start
            )
            Box(
                modifier = Modifier.padding(start = 16.dp, top = 6.dp)
            ) {
                Button(onClick = { expandedTo = true }) {
                    Text(text = selectedTo.unitName)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )
                }

                DropdownMenu(
                    expanded = expandedTo,
                    onDismissRequest = { expandedTo = false },
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 16.dp)
                ) {
                    unitsList.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(text = item.name) },
                            onClick = {
                                selectedTo = item
                                expandedTo = false
                                Toast.makeText(context, item.name, Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }
            }
        }

        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                result = ""
                inputValue = it
            },
            label = { Text(text = "Enter Value") },
            placeholder = { Text(text = "Enter Value") },
            modifier = Modifier
                .padding(all = 18.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )

        Button(
            onClick = {
                    val df = DecimalFormat("#.##")
                    df.roundingMode = RoundingMode.CEILING
                    result = df.format(inputValue.text.toInt() * selectedTo.unit / selectedFrom.unit).toString()
            },
            enabled = inputValue.text != "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        ) {
            Text(text = "CONVERT")
        }

        Text(
            text = "Result : $result",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(vertical = 14.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )

    }
}

@Preview
@Composable
fun Demo() {
    UnitConverter()
}