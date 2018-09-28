const state = {
  autoComplete: []
}

const mutations = {
  setAutoComplete (state, payload) {
    state.autoComplete = payload.autoComplete
  }
}

const actions = {
  getAutoComplete ({ commit, rootState }, autoComplete) {
    fetch('http://localhost:8080/autocomplete/?search=' + autoComplete,
      {
        'method': 'GET',
        'headers': new Headers({
          'Content-Type': 'application/json; charset=utf-8'
        })
      }
    )
      .then(response => response.json())
      .then(json => {
        commit({
          'type': 'setAutoComplete',
          'autoComplete': json.autoCompleteContent
        })
      })
      .catch(err => {
        console.log(err)
      })
  }
}

export default {
  state,
  actions,
  mutations
}
