export const clientId = 'ui'
export const scope = 'api'
export const clientSecret = 'd3023223c60ae47a0b8fab5e924e19a13a8d82ac'

export const getHeader = function () {
  const tokenData = JSON.parse(window.localStorage.getItem('authUser'))
  const headers = {
    'Accept': 'application/json',
    'Authorization':'Bearer '+tokenData.access_token
  }
  return headers
}
