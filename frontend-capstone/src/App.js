import './App.css';
import SignIn from './pages/User/SignIn';
import ResponsiveAppBar from './pages/Navbar';
import SignUp from './pages/User/SignUp';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Home from './pages/admin/Home';

function App() {
  return (
    <main>
      <div className="App">
        <ResponsiveAppBar/>

        <Router>
          <Routes>
              <Route path='/' element={<Home/>} />
              <Route path="/signup" element={<SignUp/>} />
              <Route path='/home' element={<Home/>} />
              <Route path='/signin' element={<SignIn/>} />
          </Routes>
        </Router>
      </div>
    </main>
  );
}

export default App;
