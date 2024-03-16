package io.github.henriquemcc.computacaografica.trabalhopratico.visao

import java.io.File
import javax.swing.JFileChooser
import javax.swing.filechooser.FileFilter

/**
 * Janelas para salvar e carregar arquivo.
 */
class JanelaArquivo
{
	/**
	 * Recurso do java que exibe a tela para salvar e abrir arquivos.
	 */
	private val fileChooser = JFileChooser()

	/**
	 * Constrói uma nova instância de JanelaArquivo.
	 */
	init
	{
		fileChooser.resetChoosableFileFilters()
		fileChooser.addChoosableFileFilter(FileTypeFilter(".cgg", "Configuração Gráfica"))
		fileChooser.isAcceptAllFileFilterUsed = false
	}

	/**
	 * Exibe uma janela para salvar arquivo.
	 * @return Caminho do arquivo a ser salvo.
	 */
	fun janelaSalvar(): String? {
		val saveDialogResult = fileChooser.showSaveDialog(null)
		var filePath = fileChooser.selectedFile.absolutePath
		if (!filePath.endsWith(".cgg"))
			filePath += ".cgg"

		return  if (saveDialogResult == JFileChooser.APPROVE_OPTION) filePath
		        else null
	}

	/**
	 * Exibe uma janela para abrir arquivo.
	 * @return Caminho do arquivo a ser aberto.
	 */
	fun janelaAbrir(): String? {
		val openDialogResult = fileChooser.showOpenDialog(null)

		return if (openDialogResult == JFileChooser.APPROVE_OPTION) fileChooser.selectedFile.absolutePath
		       else null
	}

	/**
	 * Tipo de arquivo a ser salvo.
	 * @param extension Extensão do arquivo.
	 * @param description Descrição do tipo de arquivo.
	 */
	class FileTypeFilter(private val extension: String, private val description: String): FileFilter() {

		/**
		 * Verifica se o nome do arquivo é desse tipo.
		 */
		override fun accept(file: File?): Boolean
		{
			return file?.name?.endsWith(extension) == true
		}

		/**
		 * Obtém a descrição do tipo do arquivo.
		 */
		override fun getDescription(): String
		{
			return description
		}

	}
}