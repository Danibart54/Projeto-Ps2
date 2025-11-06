import React from 'react';

const ListaVagasPublica = () => {
  return (
    <div>
      <h2>Vagas Abertas</h2>
      <p>Buscando todas as vagas disponíveis...</p>
      
      {/* TODO: Fazer a busca na API por TODAS as vagas
          e renderizar usando o <VagaCard /> */}
          
      <div className="form-container" style={{ textAlign: 'center' }}>
        <p>(Funcionalidade de listagem pública pendente de implementação)</p>
      </div>
    </div>
  );
};

export default ListaVagasPublica;