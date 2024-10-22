import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  base: './',
  plugins: [react()],

  server: {
    port: 3000
  },

  // import시 절대경로 지정시 as 이름 지정.
  resolve: {
    alias: {
      src: "/src",
    }
  },   
})