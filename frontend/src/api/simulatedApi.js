import axios from "axios";

// ⚙️ URL base — troque para o endereço do seu backend no Codespaces ou localhost
const api = axios.create({
  baseURL: "https://<seu-usuario>-8080.app.github.dev/api/v1",
});

// --- API DE AUTENTICAÇÃO ---
export const apiLogin = async (email, senha, tipo) => {
  const response = await api.post("/auth/login", { email, senha, tipo });
  return response.data;
};

// --- API DO ADMIN ---
export const apiGetAreas = async () => {
  const response = await api.get("/areas");
  return response.data;
};

export const apiAddArea = async (nomeArea) => {
  const response = await api.post("/areas", { nome: nomeArea });
  return response.data;
};

export const apiDeleteArea = async (idArea) => {
  const response = await api.delete(`/areas/${idArea}`);
  return response.data;
};

// --- API DE VAGAS ---
export const apiCreateVaga = async (vagaData) => {
  const response = await api.post("/vagas", vagaData);
  return response.data;
};

export const apiGetVagasPorInteresse = async (areas) => {
  const response = await api.post("/vagas/interesses", { areas });
  return response.data;
};

export default api;
