import random

#define epsilon como cadeia vazia
epsilon = ''

class GLC:
    def init(self, terminais, nao_terminais, producoes, simbolo_inicial):
        self.terminais = terminais  # Conjunto de terminais
        self.nao_terminais = nao_terminais  # Conjunto de não-terminais
        self.producoes = producoes  # Produções da GLC
        self.simbolo_inicial = simbolo_inicial  # Símbolo inicial

    def gerar_cadeia(self, simbolo=None, derivação=''):
        if simbolo is None:
            simbolo = self.simbolo_inicial

        if simbolo in self.terminais:
            return simbolo, derivação + simbolo

        producoes = self.producoes[simbolo]


        producao_escolhida = random.choice(producoes)

        cadeia = ""
        nova_derivação = derivação + simbolo + derivaçãp + ' -> '

        for s in producao_escolhida:
            simb, deriv = self.gerar_cadeia(s)
            cadeia += simb
            nova_derivação += deriv

        return cadeia, nova_derivação


#Aqui é onde a gramática é alterada
terminais = {'1', '0'} 
nao_terminais = {'S'}
producoes = {
    'S': ['0S1' , epsilon],
}
simbolo_inicial = 'S'

glc =  GLC(terminais, nao_terminais, producoes, simbolo_inicial)

#Gera uma cadeia aleatória a partir da GLC
cadeia_gerada, derivação = glc.gerar_cadeia()

print("Derivação mais à esquerda:", derivação)
print("Cadeia gerada:", cadeia_gerada)