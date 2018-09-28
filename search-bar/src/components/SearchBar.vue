<template>
  <div>
    <h2> LogicHub AutoComplete Search: </h2>
    <div class="autocomplete">
      <input type="text" v-model="search" @input="onChange" />
      <ul
          v-show="isOpen"
          class="autocomplete-results"
        >
          <li
            v-for="(result, i) in autoCompleteResults"
            :key="i"
            @click="setResult(result)"
            class="autocomplete-result"
          >
            {{ result }}
          </li>
        </ul>
    </div>
  </div>
</template>

<script>

import {mapState} from 'vuex'

export default {
  name: 'SearchBar',
  computed: mapState({
    autoCompleteResults: state => state.autocomplete.autoComplete
  }),
  data: function () {
    return {
      search: '',
      isOpen: false
    }
  },
  methods: {
    onChange: function () {
      this.isOpen = true
      this.$store.dispatch('getAutoComplete', this.search)
    },
    setResult: function (result) {
      this.search = result
      this.isOpen = false
    },
    handleClickOutside: function (evt) {
      if (!this.$el.contains(evt.target)) {
        this.isOpen = false
      }
    }
  },
  mounted: function () {
    document.addEventListener('click', this.handleClickOutside)
  },
  destroyed: function () {
    document.removeEventListener('click', this.handleClickOutside)
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.autocomplete {
  margin: 0 auto;
  width: 160px;
}

.autocomplete-results {
  padding: 0;
  margin: 0;
  border: 1px solid #eeeeee;
  height: 120px;
  overflow: auto;
}

.autocomplete-result {
  list-style: none;
  text-align: left;
  padding: 4px 2px;
  cursor: pointer;
}

.autocomplete-result:hover {
  background-color: #4AAE9B;
  color: white;
}
</style>
