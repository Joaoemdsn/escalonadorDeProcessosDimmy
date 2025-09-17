# Escalonador de Processos

Este projeto simula um escalonador de processos com três filas de prioridade (alta, média e baixa) e uma fila de bloqueados. O objetivo é demonstrar como processos são gerenciados e executados conforme suas prioridades e necessidades de recursos.

## Funcionamento

- **Processos** são lidos do arquivo `processos.txt` e distribuídos nas filas de prioridade conforme o valor informado.
- A cada ciclo de CPU, o escalonador seleciona o próximo processo a ser executado, priorizando a fila de alta prioridade.
- Se um processo precisa de um recurso bloqueante (por exemplo, DISCO), ele é movido para a fila de bloqueados e só retorna após um ciclo.
- Existe uma regra anti-inanição: após 5 ciclos consecutivos executando processos de alta prioridade, o escalonador força a execução de um processo de prioridade menor, se houver.
- Quando um processo termina todos os seus ciclos, ele é removido do sistema.

## Formato do arquivo `processos.txt`

Cada linha representa um processo e deve seguir o formato:

```
id;nome;prioridade;ciclosNecessarios;recursoNecessario
```

- **id**: Número inteiro identificador do processo.
- **nome**: Nome do processo.
- **prioridade**: 1 (alta), 2 (média), 3 (baixa).
- **ciclosNecessarios**: Número de ciclos de CPU necessários para o processo terminar.
- **recursoNecessario**: Nome do recurso necessário (`CPU`, `DISCO`, `MEMORIA`, etc).

### Exemplo

```
1;Editor;1;5;DISCO
2;Compilador;2;3;MEMORIA
3;Navegador;3;4;DISCO
```

Linhas em branco ou iniciadas por `#` são ignoradas.

## Execução

Basta executar o programa principal (`Main.java`). O sistema irá ler os processos do arquivo, simular os ciclos de CPU e mostrar o estado das filas a cada ciclo.

```bash
javac -d bin src/model/*.java src/scheduler/*.java
java -cp bin scheduler.Main
```