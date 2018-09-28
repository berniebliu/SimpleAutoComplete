import Vue from 'vue'
import Vuex from 'vuex'

import autocomplete from './store/modules/autocomplete'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    autocomplete
  }
})
