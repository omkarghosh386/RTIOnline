import RequestList from './pages/RequestList';

import { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import Home from './Home';
import FirstAppeal from './FirstAppeal';

import ScrollToTopButton from './components/ScrollToTopButton';
import HelpdeskSupportButton from './components/HelpdeskSupportButton';
import TopBar from './components/TopBar';
import Header from './components/Header';
import Footer from './components/Footer';
import BottomBar from './components/BottomBar';
import SubmitRequest from './SubmitRequest';
import ViewStatus from './ViewStatus';

export default function App() {
  const [active, setActive] = useState('new');

  return (
    <>
      <TopBar />
      <Header />
      
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/first-appeal" element={<FirstAppeal />} />
        <Route path="/submit-rti" element={<SubmitRequest />} />
        <Route path="view-status" element={<ViewStatus />} />
        <Route path="/rti-requests" element={<RequestList />} />

      </Routes>

      <Footer />
      <BottomBar />
      <ScrollToTopButton />
      <HelpdeskSupportButton />
    </>
  );
}
