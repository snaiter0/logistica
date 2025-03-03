import os
import csv
from collections import defaultdict
import json
import sys
from datetime import datetime

# Obtém o caminho absoluto do diretório do script
SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))

# Define o diretório base para salvar os arquivos
BASE_DIR = os.path.abspath(os.path.join(SCRIPT_DIR, "../../extrato_produto"))

def garantir_diretorio():
    """Garante que o diretório onde os arquivos serão salvos existe."""
    if not os.path.exists(BASE_DIR):
        os.makedirs(BASE_DIR)
        print(f"Diretório criado: {BASE_DIR}")

def processar_dados_dinamicamente(item):
    """Converte todos os campos de um item para string."""
    for chave, valor in item.items():
        # Garantir que todos os valores sejam strings, ou vazio se None
        item[chave] = str(valor) if valor is not None else ""
    return item

def gerar_csv_dinamico(lista_dict, nome_arquivo):
    """Gera um arquivo CSV com separador ';' a partir de uma lista de dicionários."""
    if lista_dict:
        # Obter todos os campos possíveis, unindo as chaves de todos os dicionários
        campos = set()
        for item in lista_dict:
            campos.update(item.keys())

        campos = sorted(campos)  # Ordenar para garantir consistência nas colunas

        # Caminho completo do arquivo
        caminho_arquivo = os.path.join(BASE_DIR, nome_arquivo)

        with open(caminho_arquivo, mode='w', newline='', encoding='utf-8') as file:
            writer = csv.DictWriter(file, fieldnames=campos, delimiter=';')
            writer.writeheader()  # Escrever o cabeçalho

            for item in lista_dict:
                item = processar_dados_dinamicamente(item)  # Garantir que todos os dados sejam strings
                writer.writerow(item)
                print(f"Escrevendo linha: {item}")

        print(f"Arquivo CSV '{caminho_arquivo}' gerado com sucesso!")
    else:
        print("A lista está vazia. Nenhum arquivo CSV foi gerado.")

def gerar_csv_por_mes(lista_dict, campo_data):
    """Gera arquivos CSV agrupados por mês com base no campo de data fornecido."""
    produtos_por_mes = defaultdict(list)
    for item in lista_dict:
        if campo_data in item:
            try:
                # Extraindo o mês a partir do campo de data
                mes = item[campo_data][:7]  # Formato YYYY-MM
                produtos_por_mes[mes].append(item)
            except Exception as e:
                print(f"Erro ao processar data no item: {e}")
        else:
            print(f"Campo '{campo_data}' não encontrado em um dos itens.")

    for mes, items in produtos_por_mes.items():
        gerar_csv_dinamico(items, f'produtos_{mes}.csv')

if __name__ == "__main__":
    # Garante que o diretório existe antes de gerar arquivos
    garantir_diretorio()

    # Ler JSON da entrada padrão
    entrada = sys.stdin.read()
    try:
        data_atual = datetime.now().strftime("%Y-%m-%d_%H-%M-%S")
        
        lista_dict = json.loads(entrada)
        print("Dados recebidos com sucesso. Processando...")

        # Gerar o arquivo CSV com dados de produto
        gerar_csv_dinamico(lista_dict, f'extrato_produtos_{data_atual}.csv')

    except json.JSONDecodeError as e:
        print(f"Erro ao decodificar o JSON: {e}")
