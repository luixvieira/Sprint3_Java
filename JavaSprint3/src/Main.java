package main; // Define o pacote onde a classe Main está localizada

// Importação das classes necessárias para o funcionamento do programa
import service.ProntuarioService; // Importa a classe de serviço para gerenciar prontuários
import service.MecanicoService;   // Importa a classe de serviço para gerenciar mecânicos
import service.FiliadosService;   // Importa a classe de serviço para gerenciar filiados
import util.ConexaoDB;            // Importa a classe que gerencia a conexão com o banco de dados
import model.Prontuario;          // Importa o modelo da entidade Prontuario
import model.Filiados;            // Importa o modelo da entidade Filiados
import java.sql.Connection;       // Importa a classe Connection para a conexão com o banco de dados
import java.sql.Statement;        // Importa a classe Statement para executar comandos SQL
import java.util.Scanner;         // Importa a classe Scanner para ler a entrada do usuário

public class Main { // Define a classe principal do programa
    // Cria um objeto Scanner para ler a entrada do usuário a partir do console
    private static Scanner scanner = new Scanner(System.in);

    // Instancia objetos de serviço para gerenciar as operações de prontuários, mecânicos e filiados
    private static ProntuarioService prontuarioService = new ProntuarioService();
    private static MecanicoService mecanicoService = new MecanicoService();
    private static FiliadosService filiadosService = new FiliadosService();

    // Método principal do programa, que será executado quando o programa iniciar
    public static void main(String[] args) {
        // Chama métodos para criar as tabelas no banco de dados, se elas ainda não existirem
        criarTabelaProntuarios();
        criarTabelaVeiculos();
        criarTabelaClientes();
        criarTabelaMecanicos();
        criarTabelaOficinas();

        // Chama o método para exibir o menu principal ao usuário
        exibirMenuPrincipal();
    }

    // Método para criar a tabela PRONTUARIOS no banco de dados
    public static void criarTabelaProntuarios() {
        Connection conn = null;  // Declara uma variável para a conexão com o banco de dados
        Statement stmt = null;   // Declara uma variável para o Statement, que executa comandos SQL

        try {
            conn = ConexaoDB.getConnection(); // Abre uma conexão com o banco de dados
            stmt = conn.createStatement();    // Cria um Statement para enviar comandos SQL ao banco

            // SQL que cria a tabela PRONTUARIOS, se ela ainda não existir
            String sql = "CREATE TABLE IF NOT EXISTS PRONTUARIOS (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +   // Coluna id com auto incremento e chave primária
                    "historico VARCHAR(255), " +              // Coluna para armazenar o histórico
                    "dataUltimaManutencao VARCHAR(50))";      // Coluna para armazenar a data da última manutenção

            stmt.executeUpdate(sql); // Executa o comando SQL para criar a tabela
            System.out.println("Tabela PRONTUARIOS criada com sucesso!"); // Exibe mensagem de sucesso

        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante a criação da tabela
            System.out.println("Erro ao criar tabela PRONTUARIOS: " + e.getMessage()); // Exibe mensagem de erro
        } finally { // Bloco finally é sempre executado, independentemente de ocorrer uma exceção ou não
            try {
                if (stmt != null) stmt.close(); // Fecha o Statement, se ele foi aberto
                if (conn != null) conn.close(); // Fecha a conexão com o banco de dados, se ela foi aberta
            } catch (Exception e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage()); // Exibe mensagem de erro ao fechar recursos
            }
        }
    }

    // Método para criar a tabela VEICULOS no banco de dados
    public static void criarTabelaVeiculos() {
        Connection conn = null; // Declara uma variável para a conexão com o banco de dados
        Statement stmt = null;  // Declara uma variável para o Statement

        try {
            conn = ConexaoDB.getConnection(); // Abre uma conexão com o banco de dados
            stmt = conn.createStatement();    // Cria um Statement para enviar comandos SQL ao banco

            // SQL que cria a tabela VEICULOS, se ela ainda não existir
            String sql = "CREATE TABLE IF NOT EXISTS VEICULOS (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +  // Coluna id com auto incremento e chave primária
                    "modelo VARCHAR(255), " +                // Coluna para armazenar o modelo do veículo
                    "marca VARCHAR(255), " +                 // Coluna para armazenar a marca do veículo
                    "ano INT)";                              // Coluna para armazenar o ano do veículo

            stmt.executeUpdate(sql); // Executa o comando SQL para criar a tabela
            System.out.println("Tabela VEICULOS criada com sucesso!"); // Exibe mensagem de sucesso

        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante a criação da tabela
            System.out.println("Erro ao criar tabela VEICULOS: " + e.getMessage()); // Exibe mensagem de erro
        } finally { // Bloco finally é sempre executado, independentemente de ocorrer uma exceção ou não
            try {
                if (stmt != null) stmt.close(); // Fecha o Statement, se ele foi aberto
                if (conn != null) conn.close(); // Fecha a conexão com o banco de dados, se ela foi aberta
            } catch (Exception e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage()); // Exibe mensagem de erro ao fechar recursos
            }
        }
    }

    // Método para criar a tabela CLIENTES no banco de dados
    public static void criarTabelaClientes() {
        Connection conn = null; // Declara uma variável para a conexão com o banco de dados
        Statement stmt = null;  // Declara uma variável para o Statement

        try {
            conn = ConexaoDB.getConnection(); // Abre uma conexão com o banco de dados
            stmt = conn.createStatement();    // Cria um Statement para enviar comandos SQL ao banco

            // SQL que cria a tabela CLIENTES, se ela ainda não existir
            String sql = "CREATE TABLE IF NOT EXISTS CLIENTES (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +  // Coluna id com auto incremento e chave primária
                    "nome VARCHAR(255), " +                  // Coluna para armazenar o nome do cliente
                    "endereco VARCHAR(255), " +              // Coluna para armazenar o endereço do cliente
                    "telefone VARCHAR(50))";                // Coluna para armazenar o telefone do cliente

            stmt.executeUpdate(sql); // Executa o comando SQL para criar a tabela
            System.out.println("Tabela CLIENTES criada com sucesso!"); // Exibe mensagem de sucesso

        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante a criação da tabela
            System.out.println("Erro ao criar tabela CLIENTES: " + e.getMessage()); // Exibe mensagem de erro
        } finally { // Bloco finally é sempre executado, independentemente de ocorrer uma exceção ou não
            try {
                if (stmt != null) stmt.close(); // Fecha o Statement, se ele foi aberto
                if (conn != null) conn.close(); // Fecha a conexão com o banco de dados, se ela foi aberta
            } catch (Exception e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage()); // Exibe mensagem de erro ao fechar recursos
            }
        }
    }

    // Método para criar a tabela MECANICOS no banco de dados
    public static void criarTabelaMecanicos() {
        Connection conn = null; // Declara uma variável para a conexão com o banco de dados
        Statement stmt = null;  // Declara uma variável para o Statement

        try {
            conn = ConexaoDB.getConnection(); // Abre uma conexão com o banco de dados
            stmt = conn.createStatement();    // Cria um Statement para enviar comandos SQL ao banco

            // SQL que cria a tabela MECANICOS, se ela ainda não existir
            String sql = "CREATE TABLE IF NOT EXISTS MECANICOS (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +  // Coluna id com auto incremento e chave primária
                    "nome VARCHAR(255), " +                  // Coluna para armazenar o nome do mecânico
                    "especialidade VARCHAR(255), " +         // Coluna para armazenar a especialidade do mecânico
                    "experiencia INT)";                      // Coluna para armazenar a experiência do mecânico

            stmt.executeUpdate(sql); // Executa o comando SQL para criar a tabela
            System.out.println("Tabela MECANICOS criada com sucesso!"); // Exibe mensagem de sucesso

        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante a criação da tabela
            System.out.println("Erro ao criar tabela MECANICOS: " + e.getMessage()); // Exibe mensagem de erro
        } finally { // Bloco finally é sempre executado, independentemente de ocorrer uma exceção ou não
            try {
                if (stmt != null) stmt.close(); // Fecha o Statement, se ele foi aberto
                if (conn != null) conn.close(); // Fecha a conexão com o banco de dados, se ela foi aberta
            } catch (Exception e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage()); // Exibe mensagem de erro ao fechar recursos
            }
        }
    }

    // Método para criar a tabela OFICINAS no banco de dados
    public static void criarTabelaOficinas() {
        Connection conn = null; // Declara uma variável para a conexão com o banco de dados
        Statement stmt = null;  // Declara uma variável para o Statement

        try {
            conn = ConexaoDB.getConnection(); // Abre uma conexão com o banco de dados
            stmt = conn.createStatement();    // Cria um Statement para enviar comandos SQL ao banco

            // SQL que cria a tabela OFICINAS, se ela ainda não existir
            String sql = "CREATE TABLE IF NOT EXISTS OFICINAS (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +  // Coluna id com auto incremento e chave primária
                    "nome VARCHAR(255), " +                  // Coluna para armazenar o nome da oficina
                    "endereco VARCHAR(255))";                // Coluna para armazenar o endereço da oficina

            stmt.executeUpdate(sql); // Executa o comando SQL para criar a tabela
            System.out.println("Tabela OFICINAS criada com sucesso!"); // Exibe mensagem de sucesso

        } catch (Exception e) { // Captura qualquer exceção que possa ocorrer durante a criação da tabela
            System.out.println("Erro ao criar tabela OFICINAS: " + e.getMessage()); // Exibe mensagem de erro
        } finally { // Bloco finally é sempre executado, independentemente de ocorrer uma exceção ou não
            try {
                if (stmt != null) stmt.close(); // Fecha o Statement, se ele foi aberto
                if (conn != null) conn.close(); // Fecha a conexão com o banco de dados, se ela foi aberta
            } catch (Exception e) {
                System.out.println("Erro ao fechar recursos: " + e.getMessage()); // Exibe mensagem de erro ao fechar recursos
            }
        }
    }

    // Método para exibir o menu principal ao usuário
    public static void exibirMenuPrincipal() {
        while (true) { // Loop infinito que mantém o menu ativo até o usuário escolher sair
            System.out.println("=== Bem-vindo ao Sistema de Auto Atendimento Porto ===");
            System.out.println("Selecione o tipo de usuário:");
            System.out.println("1. Mecânico Porto");   // Opção para mecânico
            System.out.println("2. Segurado Porto");   // Opção para segurado
            System.out.println("3. Sair");             // Opção para sair do programa
            String opcao = scanner.nextLine(); // Lê a escolha do usuário

            // Verifica qual opção o usuário escolheu e chama o método correspondente
            if (opcao.equals("1")) {
                exibirMenuMecanico(); // Mostra o menu para Mecânico
            } else if (opcao.equals("2")) {
                exibirMenuSegurado(); // Mostra o menu para Segurado
            } else if (opcao.equals("3")) {
                System.out.println("Encerrando o programa. Obrigado!");
                break; // Sai do loop e encerra o programa
            } else {
                System.out.println("Opção inválida. Tente novamente."); // Mensagem de erro para opção inválida
            }
        }
    }

    // Método para exibir o menu do Mecânico e gerenciar as operações disponíveis
    public static void exibirMenuMecanico() {
        while (true) { // Loop infinito que mantém o menu ativo até o usuário escolher voltar ao menu principal
            System.out.println("=== Menu Mecânico Porto ===");
            System.out.println("1. Visualizar prontuário de um carro");  // Opção para visualizar um prontuário
            System.out.println("2. Adicionar uma reforma ao prontuário"); // Opção para adicionar uma reforma
            System.out.println("3. Alterar uma reforma");                 // Opção para alterar uma reforma
            System.out.println("4. Excluir uma reforma");                 // Opção para excluir uma reforma
            System.out.println("5. Visualizar pré-diagnóstico feito");    // Opção para visualizar pré-diagnóstico
            System.out.println("6. Voltar ao menu principal");            // Opção para voltar ao menu principal
            String opcao = scanner.nextLine(); // Lê a escolha do usuário

            // Verifica qual opção o usuário escolheu e chama o método correspondente
            if (opcao.equals("1")) {
                prontuarioService.exibirProntuario(obterIdProntuario()); // Exibe um prontuário específico
            } else if (opcao.equals("2")) {
                prontuarioService.adicionarProntuario(criarProntuario()); // Adiciona uma reforma ao prontuário
            } else if (opcao.equals("3")) {
                prontuarioService.atualizarProntuario(criarProntuario()); // Altera uma reforma no prontuário
            } else if (opcao.equals("4")) {
                prontuarioService.removerProntuario(obterIdProntuario()); // Remove uma reforma do prontuário
            } else if (opcao.equals("5")) {
                mecanicoService.visualizarPreDiagnostico(); // Visualiza um pré-diagnóstico feito
            } else if (opcao.equals("6")) {
                break; // Sai do loop e volta ao menu principal
            } else {
                System.out.println("Opção inválida. Tente novamente."); // Mensagem de erro para opção inválida
            }
        }
    }

    // Método para exibir o menu do Segurado e gerenciar as operações disponíveis
    public static void exibirMenuSegurado() {
        while (true) { // Loop infinito que mantém o menu ativo até o usuário escolher voltar ao menu principal
            System.out.println("=== Menu Segurado Porto ===");
            System.out.println("1. Visualizar informações do filiado");  // Opção para visualizar informações do filiado
            System.out.println("2. Atualizar informações do filiado");   // Opção para atualizar informações do filiado
            System.out.println("3. Visualizar diagnóstico do veículo");  // Opção para visualizar diagnóstico do veículo
            System.out.println("4. Voltar ao menu principal");           // Opção para voltar ao menu principal
            String opcao = scanner.nextLine(); // Lê a escolha do usuário

            // Verifica qual opção o usuário escolheu e chama o método correspondente
            if (opcao.equals("1")) {
                filiadosService.exibirInformacoesFiliado(obterIdFiliado()); // Exibe informações de um filiado específico
            } else if (opcao.equals("2")) {
                filiadosService.atualizarFiliado(criarFiliado()); // Atualiza as informações de um filiado
            } else if (opcao.equals("3")) {
                mecanicoService.visualizarDiagnosticoVeiculo(obterIdProntuario()); // Visualiza o diagnóstico de um veículo
            } else if (opcao.equals("4")) {
                break; // Sai do loop e volta ao menu principal
            } else {
                System.out.println("Opção inválida. Tente novamente."); // Mensagem de erro para opção inválida
            }
        }
    }

    // Método auxiliar para obter o ID de um prontuário a partir da entrada do usuário
    private static int obterIdProntuario() {
        int id = -1; // Variável para armazenar o ID, inicializada com valor inválido
        while (id == -1) {
            System.out.print("Digite o ID do prontuário: "); // Solicita ao usuário que digite o ID
            try {
                id = Integer.parseInt(scanner.nextLine()); // Tenta converter a entrada do usuário para número inteiro
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número válido."); // Exibe mensagem de erro
            }
        }
        return id; // Retorna o ID válido
    }

    // Método auxiliar para obter o ID de um filiado a partir da entrada do usuário
    private static int obterIdFiliado() {
        int id = -1; // Variável para armazenar o ID, inicializada com valor inválido
        while (id == -1) {
            System.out.print("Digite o ID do filiado: "); // Solicita ao usuário que digite o ID
            try {
                id = Integer.parseInt(scanner.nextLine()); // Tenta converter a entrada do usuário para número inteiro
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número válido."); // Exibe mensagem de erro
            }
        }
        return id; // Retorna o ID válido
    }

    // Método auxiliar para criar um novo prontuário a partir das informações fornecidas pelo usuário
    private static Prontuario criarProntuario() {
        Prontuario prontuario = new Prontuario(); // Cria um novo objeto Prontuario
        System.out.print("Digite o histórico: "); // Solicita ao usuário que digite o histórico
        prontuario.setHistorico(scanner.nextLine()); // Define o histórico do prontuário com a entrada do usuário
        System.out.print("Digite a data da última manutenção: "); // Solicita ao usuário que digite a data
        prontuario.setDataUltimaManutencao(scanner.nextLine()); // Define a data da última manutenção com a entrada do usuário
        return prontuario; // Retorna o prontuário criado
    }

    // Método auxiliar para criar um novo filiado a partir das informações fornecidas pelo usuário
    private static Filiados criarFiliado() {
        Filiados filiado = new Filiados(); // Cria um novo objeto Filiados
        System.out.print("Digite o nome: "); // Solicita ao usuário que digite o nome
        filiado.setNome(scanner.nextLine()); // Define o nome do filiado com a entrada do usuário
        System.out.print("Digite o endereço: "); // Solicita ao usuário que digite o endereço
        filiado.setEndereco(scanner.nextLine()); // Define o endereço do filiado com a entrada do usuário
        System.out.print("Digite o telefone: "); // Solicita ao usuário que digite o telefone
        filiado.setTelefone(scanner.nextLine()); // Define o telefone do filiado com a entrada do usuário
        return filiado; // Retorna o filiado criado
    }
}
