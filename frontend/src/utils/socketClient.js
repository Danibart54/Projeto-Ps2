export function createAppSocket(path = '/ws') {
  const scheme = window.location.protocol === 'https:' ? 'wss' : 'ws';
  const host = window.location.host; // includes port
  const url = `${scheme}://${host}${path}`;
  return new WebSocket(url);
}
