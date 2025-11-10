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

/**
 * Módulo de acesso a API do backend.
 * Usa o proxy configurado em package.json para encaminhar chamadas a http://localhost:8080 durante desenvolvimento.
 *
 * Exporta:
 *  - request(path, options)
 *  - get(path), post(path, body), put(path, body), del(path)
 *  - fetchWithFallback(path, options, fallback)
 *
 * Ajuste os caminhos (path) conforme os endpoints do seu backend, por exemplo:
 *  get('/vagas') -> GET http://localhost:8080/vagas
 */

async function request(path, { method = 'GET', body, headers = {} } = {}) {
  const opts = {
    method,
    headers: { 'Content-Type': 'application/json', ...headers },
  };
  if (body !== undefined) opts.body = JSON.stringify(body);

  try {
    const res = await fetch(path, opts);
    if (!res.ok) {
      const text = await res.text();
      throw new Error(`${res.status} ${res.statusText}: ${text}`);
    }
    const contentType = res.headers.get('content-type') || '';
    if (contentType.includes('application/json')) return await res.json();
    return await res.text();
  } catch (err) {
    // Propaga erro para o chamador; use fetchWithFallback se quiser retorno simulados
    throw err;
  }
}

async function fetchWithFallback(path, options = {}, fallback = null) {
  try {
    return await request(path, options);
  } catch (err) {
    if (fallback !== null) return fallback;
    throw err;
  }
}

export const get = (path) => request(path, { method: 'GET' });
export const post = (path, body) => request(path, { method: 'POST', body });
export const put = (path, body) => request(path, { method: 'PUT', body });
export const del = (path) => request(path, { method: 'DELETE' });

export { request, fetchWithFallback };

export default { request, get, post, put, del, fetchWithFallback };
