import React, { useState, useEffect } from 'react';
import { useAuth } from '../../contexts/AuthContext';
import { apiGetVagasPorInteresse } from '../../api/simulatedApi'; 
import VagaCard from '../../components/ui/VagaCard/VagaCard';

const PainelEstudante = () => {
  const { user } = useAuth();
  const [vagasRecomendadas, setVagasRecomendadas] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchVagas = async () => {
      if (user && user.areasDeInteresse) {
        setLoading(true);
        try {
          const vagas = await apiGetVagasPorInteresse(user.areasDeInteresse);
          setVagasRecomendadas(vagas);
        } catch (error) {
          console.error("Erro ao buscar vagas:", error);
        } finally {
          setLoading(false);
        }
      } else if (user) {
        setLoading(false);
      }
    };

    fetchVagas();
  }, [user]); 

  // ADICIONAMOS ESTA VERIFICAÇÃO:
  // Se 'user' for nulo, mostramos "Carregando..."
  // e impedimos a leitura de 'user.nome'.
  if (!user) {
    return <p>Carregando dados do usuário...</p>;
  }

  if (loading) {
    return <h2>Carregando vagas para você...</h2>;
  }

  // Agora, quando o código chega aqui, 'user' NUNCA é 'null'.
  return (
    <div>
      <h2>Olá, {user.nome}. Vagas recomendadas:</h2>
      
      {vagasRecomendadas.length === 0 && (
        <p>Nenhuma vaga encontrada para suas áreas de interesse.</p>
      )}

      <div className="lista-vagas">
        {vagasRecomendadas.map(vaga => (
          <VagaCard key={vaga.id} vaga={vaga} />
        ))}
      </div>
    </div>
  );
};

export default PainelEstudante;