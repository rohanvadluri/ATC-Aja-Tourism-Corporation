import './LandingPage.css'

function LandingPage() {
  return (
    <div className="landing-page">
      <div className="landing-content">
        <h1 className="landing-title">Aja Tourism</h1>
        <p className="landing-subtitle">Coming Soon</p>
        <p className="landing-description">
          We're working on something amazing. Stay tuned!
        </p>
        <a href="/login" className="login-link">Go to Login</a>
      </div>
    </div>
  )
}

export default LandingPage

