# Comando do compilador Java
JAVAC=javac
# Comando da JVM
JAVA=java
# ROOT é a raiz dos diretórios com todos os roteiros de laboratórios
YEAR=$(shell pwd | grep -o '20..-.')
# ROOT=/home/juliana/compiladores-labs/lab7
ROOT=/home/filipe/git/compiladores-labs/lab7
# Caminho para o JAR do ANTLR em labs/tools
ANTLR_PATH=$(ROOT)/tools/antlr-4.11.1-complete.jar
# Opção de configuração do CLASSPATH para o ambiente Java
CLASS_PATH_OPTION=-cp .:$(ANTLR_PATH)
# Configuração do comando de compilação do ANTLR
ANTLR4=$(JAVA) -jar $(ANTLR_PATH)
# Configuração do ambiente de teste do ANTLR
GRUN=$(JAVA) $(CLASS_PATH_OPTION) org.antlr.v4.gui.TestRig
# Nome da gramática
GRAMMAR_NAME=EZ
LEXER_FILE=$(GRAMMAR_NAME)Lexer.g
PARSER_FILE=$(GRAMMAR_NAME)Parser.g
# Diretório para aonde vão os arquivos gerados
GEN_PATH=parser
# Diretório para os arquivos .class
BIN_PATH=bin

# Executa o ANTLR e o compilador Java
all: antlr javac
	@echo "Done."
# Executa o ANTLR para compilar a gramática
antlr: $(LEXER_FILE) $(PARSER_FILE)
	$(ANTLR4) -no-listener -visitor -o $(GEN_PATH) $(LEXER_FILE) $(PARSER_FILE)
# Compila todos os subdiretórios e joga todos os .class em BIN_PATH pra organizar
javac:
	rm -rf $(BIN_PATH)
	mkdir $(BIN_PATH)
	$(JAVAC) $(CLASS_PATH_OPTION) -d $(BIN_PATH) */*.java Main.java
# Executa o front-end. Comando: $ make run FILE=arquivo_de_teste
# 'Main' é a classe com a função principal
run:
	$(JAVA) $(CLASS_PATH_OPTION):$(BIN_PATH) Main $(FILE)
# Executa o TestRig para exibir a parse tree
debug:
	cd $(BIN_PATH) && $(GRUN) $(GRAMMAR_NAME) program -gui $(FILE)
# Compila o simulador da Tiny Machine.
tm:
	cd tmcode && gcc -Wall -Wconversion -o ../tmsim tm.c tables.c types.c
# Remove os arquivos gerados pelo ANTLR
clean:
	@rm -rf $(GEN_PATH) $(BIN_PATH) tmsim





# # Comando do compilador Java
# JAVAC=javac
# # Comando da JVM
# JAVA=java
# # ROOT é a raiz dos diretórios com todos os roteiros de laboratórios
# # ROOT=/home/fgasouza/compiladores-labs/lab4
# #ROOT=/home/filipe/git/compiladores-labs/lab7/
# # ROOT=/home/fgasouza/compiladores-labs/lab6/
# # ROOT=/home/jcrepossi/compiladores-labs/lab4
# ROOT=/home/juliana/compiladores-labs/lab7
# # Caminho para o JAR do ANTLR em labs/tools
# ANTLR_PATH=$(ROOT)/tools/antlr-4.11.1-complete.jar
# # Opção de configuração do CLASSPATH para o ambiente Java
# CLASS_PATH_OPTION=-cp .:$(ANTLR_PATH)
# # Configuração do comando de compilação do ANTLR
# ANTLR4=$(JAVA) -jar $(ANTLR_PATH)
# # Configuração do ambiente de teste do ANTLR
# GRUN=$(JAVA) $(CLASS_PATH_OPTION) org.antlr.v4.gui.TestRig
# # Nome da gramática
# GRAMMAR_NAME=EZ
# LEXER_NAME=EZLexer
# PARSER_NAME=EZParser
# # Diretório para aonde vão os arquivos gerados
# GEN_PATH=parser
# # Diretório para os arquivos .class
# BIN_PATH=bin

# # Executa o ANTLR e o compilador Java
# all: antlr javac
# 	@echo "Done."
# # Executa o ANTLR para compilar a gramática
# antlr: $(LEXER_NAME).g $(PARSER_NAME).g
# 	$(ANTLR4) -no-listener -visitor -o $(GEN_PATH) $(LEXER_NAME).g $(PARSER_NAME).g
# # Compila todos os subdiretórios e joga todos os .class em BIN_PATH pra organizar
# javac:
# 	rm -rf $(BIN_PATH)
# 	mkdir $(BIN_PATH)
# 	$(JAVAC) $(CLASS_PATH_OPTION) -d $(BIN_PATH) */*.java Main.java
# # Executa o front-end. Comando: $ make run FILE=arquivo_de_teste
# # 'Main' é a classe com a função principal
# run:
# 	$(JAVA) $(CLASS_PATH_OPTION):$(BIN_PATH) Main $(FILE)

# debug:
# 	cd $(BIN_PATH) && $(GRUN) $(GEN_PATH).$(GRAMMAR_NAME) line -gui $(FILE)
# # Remove os arquivos gerados pelo ANTLR
# clean:
# 	@rm -rf $(GEN_PATH) $(BIN_PATH)
