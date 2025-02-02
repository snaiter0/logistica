package br.sp.oz.portal.logistica.service.impl.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;

import org.springframework.core.io.FileSystemResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PythonExecutor {
	
    public static FileSystemResource executarConversaoCsv(Set<?> produtos) {
        log.warn("Tentativa de conversao de DTO para CSV.");
        try {
            // Converter a lista de produtos em JSON
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
            String produtosJson = objectMapper.writeValueAsString(produtos);

            // Caminho do script Python
            String scriptPath = new FileSystemResource("src/main/resources/scripts/python/ProdutoDTO.py").getFile().getAbsolutePath();

            // Caminho do executável Python
            String pythonPath = "C:\\Users\\snaiter\\AppData\\Local\\Programs\\Python\\Python313\\python.exe";

            // Criar o processo para executar o Python
            ProcessBuilder processBuilder = new ProcessBuilder(pythonPath, scriptPath);
            processBuilder.redirectErrorStream(true);

            // Enviar o JSON como entrada para o processo
            Process process = processBuilder.start();
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
                writer.write(produtosJson); // Escreve o JSON na entrada do processo
                writer.flush();
            }

            // Capturar a saída do script Python e procurar o nome do arquivo gerado
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            String nomeArquivo = null;  // Variável para armazenar o nome do arquivo

            // Lê a saída do script e busca pelo nome do arquivo
            while ((line = reader.readLine()) != null) {
                log.info(line);  // Exibe a saída do script Python
                if (line.contains("Arquivo CSV") && line.contains("gerado com sucesso")) {
                    // Supondo que o log siga o formato: "Arquivo CSV 'caminho' gerado com sucesso!"
                    // Extraímos o caminho do arquivo da linha
                    nomeArquivo = line.split("'")[1]; // Pegando o caminho entre as aspas
                    break;
                }
            }

            int exitCode = process.waitFor();
            log.warn("Process finished with exit code: " + exitCode);

            if (nomeArquivo != null) {
                // Criar o FileSystemResource com o caminho do arquivo
                FileSystemResource fileResource = new FileSystemResource(nomeArquivo);
                return fileResource;
            } else {
                log.error("Arquivo não encontrado no log de saída.");
                return null;
            }

        } catch (IOException | InterruptedException e) {
            log.error("Erro ao executar o script Python ou gerar o arquivo.", e);
            return null;
        }
    }
}
