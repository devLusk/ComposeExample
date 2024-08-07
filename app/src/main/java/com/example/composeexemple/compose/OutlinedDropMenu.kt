package com.example.composeexemple.compose

import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeexemple.ui.theme.ComposeExempleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropMenu(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val (isMenuExpanded, setMenuExpanded) = remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = isMenuExpanded,
        onExpandedChange = setMenuExpanded
    ) {
        OutlinedTextField(
            value = selectedOption,
            placeholder = {
                Text("Opções")
            },
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isMenuExpanded)
            },
            modifier = Modifier
                .menuAnchor()
                .width(140.dp)
        )

        ExposedDropdownMenu(
            expanded = isMenuExpanded,
            onDismissRequest = { setMenuExpanded(false) }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        setMenuExpanded(false)
                        onOptionSelected(option)
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ExposedDropMenuPreview() {
    val (selectedOption, setSelectedOption) = remember { mutableStateOf("") }
    ComposeExempleTheme {
        ExposedDropMenu(
            options = List(10) { (it + 1).toString() },
            selectedOption = selectedOption,
            onOptionSelected = setSelectedOption
        )
    }
}