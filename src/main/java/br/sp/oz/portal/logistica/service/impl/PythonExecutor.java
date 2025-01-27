package br.sp.oz.portal.logistica.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PythonExecutor {

    public void executarConversaoCsv(Set<?> produtos) {
    	log.warn("Tentativa de conversao de DTO para CSV.");
        try {
            // Converter a lista de produtos em JSON
            ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
            String produtosJson = objectMapper.writeValueAsString(produtos);

            // Caminho do script Python
            String scriptPath = "C:\\Users\\snaiter\\eclipse-workspace\\logisticaApplication\\src\\main\\resources\\ProdutoDTO.py";

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

            // Capturar a saída do script Python
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Exibir a saída do script
            }

            int exitCode = process.waitFor();
            log.warn("Process finished with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
