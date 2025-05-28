package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obterTraducao(String texto) {
        OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduza para o português o texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var resposta = service.createCompletion(requisicao);
        return resposta.getChoices().get(0).getText();
    }
}