import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader {
    
    public static void main(String[] args) {
        try {
            // Criar diretório se não existir
            new File("data/operadoras").mkdirs();
            
            // Download operadoras ativas
            String operadorasUrl = "https://dadosabertos.ans.gov.br/FTP/PDA/operadoras_de_plano_de_saude_ativas/Relatorio_cadop.csv";
            downloadFile(operadorasUrl, "data/operadoras/Relatorio_cadop.csv");
            
            // Download demonstrações contábeis (últimos 2 anos)
            int currentYear = java.time.Year.now().getValue();
            for (int year = currentYear - 1; year <= currentYear; year++) {
                String demoUrl = String.format(
                    "https://dadosabertos.ans.gov.br/FTP/PDA/demonstracoes_contabeis/%d/DemonstracoesContabeis_%d.zip",
                    year, year);
                downloadFile(demoUrl, String.format("data/demonstracoes_%d.zip", year));
            }
            
        } catch (IOException e) {
        }
    }
    
    private static void downloadFile(String urlStr, String outputFile) throws IOException {
        System.out.println("Downloading: " + urlStr);
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
        System.out.println("Saved to: " + outputFile);
    }
}