package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import java.io.File
import javax.swing.JFileChooser
import javax.swing.filechooser.FileFilter

class JanelaArquivo
{
	private val fileChooser = JFileChooser()

	init
	{
		fileChooser.resetChoosableFileFilters()
		fileChooser.addChoosableFileFilter(FileTypeFilter(".cgg", "Configuração Gráfica"))
		fileChooser.isAcceptAllFileFilterUsed = false
	}

	fun janelaSalvar(): String? {
		val saveDialogResult = fileChooser.showSaveDialog(null)
		var filePath = fileChooser.selectedFile.absolutePath
		if (!filePath.endsWith(".cgg"))
			filePath += ".cgg"

		return  if (saveDialogResult == JFileChooser.APPROVE_OPTION) filePath
		        else null
	}

	fun janelaAbrir(): String? {
		val openDialogResult = fileChooser.showOpenDialog(null)

		return if (openDialogResult == JFileChooser.APPROVE_OPTION) fileChooser.selectedFile.absolutePath
		       else null
	}

	class FileTypeFilter(private val extension: String, private val description: String): FileFilter() {
		override fun accept(file: File?): Boolean
		{
			return file?.name?.endsWith(extension) == true
		}

		override fun getDescription(): String
		{
			return description
		}

	}
}